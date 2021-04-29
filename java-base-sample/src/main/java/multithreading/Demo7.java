package multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock和Condition
 */
public class Demo7 {

}

/**
 * await()会释放当前锁，进入等待状态；
 * <p>
 * signal()会唤醒某个等待线程；
 * <p>
 * signalAll()会唤醒所有等待线程；
 * <p>
 * 唤醒线程从await()返回后需要重新获得锁。
 */
class TaskQueue2 {

    private final Lock lock = new ReentrantLock ();
    private final Condition condition = lock.newCondition ();
    private Queue<String> queue = new LinkedList ();


    public String getTask() {
        lock.lock ();
        try {
            while (queue.isEmpty ()) {
                condition.await ();
            }
        } catch (InterruptedException e) {
            e.printStackTrace ();
        } finally {
            lock.unlock ();
        }
        return queue.remove ();
    }

    public void addTask(String task) {
        lock.lock ();
        try {
            queue.add (task);
            condition.signalAll ();
        } finally {
            lock.unlock ();
        }
    }

    /**
     * 可尝试获取锁，如果无法被唤醒就执行其它操作，防死锁死
     *
     * @return
     */
    public String getTask2() {
        lock.lock ();
        try {
            while (queue.isEmpty ()) {
                if (condition.await (3,TimeUnit.SECONDS)) {
                    // 被其它线程唤醒
                    return queue.remove ();
                } else {
                    //指定时间内没有被其它线程唤醒
                    return null;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace ();
        } finally {
            lock.unlock ();
        }
        return queue.remove ();
    }

}