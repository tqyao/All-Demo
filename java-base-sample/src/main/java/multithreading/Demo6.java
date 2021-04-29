package multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 */
public class Demo6 {

}

class Counter {
    private final Lock lock = new ReentrantLock ();
    private int count;

    public void add(int n) {
        lock.lock ();
        // 因为synchronized是Java语言层面提供的语法，所以我们不需要考虑异常，\
        // 而ReentrantLock是Java代码实现的锁，我们就必须先获取锁，然后在finally中正确释放锁。
        try {
            count += n;
        } catch (Exception e) {
            lock.unlock ();
        }

    }

}

class Counter2 {
    private final Lock lock = new ReentrantLock ();
    private int count;

    public void add(int n) throws InterruptedException {
        //尝试获取锁
        if (lock.tryLock (1, TimeUnit.SECONDS)) {
            //最多等待1秒。如果1秒后仍未获取到锁，tryLock()返回false
            try {
                count += n;
            } finally {
                lock.unlock ();
            }
        }
    }

}