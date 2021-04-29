package multithreading.threadpool;

import java.util.concurrent.*;

public class Demo1 {
    public static void main(String[] args) {
        /**
         * 固定长度线程池
         * 添加任务就创建新线程
         * 发生位置错误结束时，补充一个线程
         */
//        Executors.newFixedThreadPool (3);

        /**
         * 缓存线程池
         * 线程池的规模超过处理需求，回收空闲线程
         * 任务需求增加自动添加新线程，线程池规模不受限制
         */
//        Executors.newCachedThreadPool ();

        /**
         * 单线程 Executor
         * 创建单个线程执行添加的任务
         * 线程池异常结束，会创建新的来代替
         * 特点：能保证依照任务队列中的执行顺序串行执行
         */
//        Executors.newSingleThreadExecutor ();

        /**
         * 创建了一个固定长度的线程池，而且以延迟或定时的方式来执行任务，类似于Timer。
         */
//        Executors.newScheduledThreadPool (3);

        // 创建3个线程池
        ExecutorService executorService = Executors.newFixedThreadPool (3);
        for (int i = 0; i < 4; i++) {
            executorService.submit (new Task ());
        }
        // 关闭线程池
        executorService.shutdown ();
    }


    //CachedThreadPool 可以根据任务数量调整线程池大小，一次性执行线程池中所有任务
    // 创建指定动态范围的线程池
    int min = 4, max = 10;
    ExecutorService es2 = new ThreadPoolExecutor (min, max,
            60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable> ());


    //ScheduledThreadPool 可反复执行线程池
    ScheduledExecutorService ses = Executors.newScheduledThreadPool (4);

//    // 1秒后执行一次性任务:
//     ses.schedule(new Task("one-time"), 1, TimeUnit.SECONDS);
//
//    // 2秒后开始执行定时任务，每3秒执行:
//    ses.scheduleAtFixedRate(new Task("fixed-rate"), 2, 3, TimeUnit.SECONDS);
//
//    // 2秒后开始执行定时任务，以3秒为间隔执行:
//    ses.scheduleWithFixedDelay(new Task("fixed-delay"), 2, 3, TimeUnit.SECONDS);
}

class Task extends Thread {

    public static int count = 0;


    @Override
    public void run() {

        synchronized (Task.class) {
            System.out.println ("task + " + count++ + ":running");
        }
        try {
            Thread.sleep (2000);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }

    }
}


class Task2 implements Runnable {
    private final String name;

    public Task2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println ("start task " + name);
        try {
            Thread.sleep (1000);
        } catch (InterruptedException e) {
        }
        System.out.println ("end task " + name);
    }
}