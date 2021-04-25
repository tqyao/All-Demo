package multithreading;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Demo5 {

    public static void main(String[] args) throws InterruptedException {
        TaskQueue tq = new TaskQueue ();
        List<Thread> threads = new ArrayList<> ();

        // 主线程创建5个执行从队列去除任务执行的线程
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread (() -> {
                String task;
                while (true) {
                    try {
                        // 等待着执行任务（等待被唤醒）
                        task = tq.getTask ();
                    } catch (InterruptedException e) {
                        return;
                    }
                    System.out.println (Thread.currentThread ().getName () + " => 执行任务" + task);
                }
            });
            thread.start ();
            threads.add (thread);
        }

        // 主线程开启一个添加任务的线程
        Thread add = new Thread (() -> {
            for (int i = 0; i < 10; i++) {
                String no = (int) (Math.random () * 1000) + "";
                System.out.println ("Add Task" + no);
                // 添加任务，且唤醒等待着锁的线程
                tq.addTask ("task:no:" + no);
                try {
                    // 每添加一个线程，休息1秒，让消费线程等待任务添加
                    Thread.sleep (1000);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        });
        add.start ();
        // 主线程等待任务添加线程执行结束再执行
        add.join ();

        Thread.sleep (100);

        // 添加任务线程执行完毕，没有任务了，中断执行任务线程等待
        for (Thread t : threads) {
            t.interrupt ();
        }

    }

}


class TaskQueue {

    Queue<String> queue = new LinkedList<> ();

    public synchronized String getTask() throws InterruptedException {

        // 必须用while或其它相关循环，不能用if。如果用if会导致当消费任务的线程被全部唤醒后，此时\
        // 某个消费线程获取this锁已经消费掉任务队列中仅有的那个任务，当前的消费线程获取到this锁执行完if语句任然去执行取队列\
        // remove()会抛出NoSuchElementException
        while (queue.isEmpty ()) {
            this.wait ();
        }
        return queue.remove ();
    }

    public synchronized void addTask(String task) {
        queue.add (task);
        this.notifyAll ();
    }
}
