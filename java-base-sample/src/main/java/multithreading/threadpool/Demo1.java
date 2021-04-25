package multithreading.threadpool;

import java.util.concurrent.*;

public class Demo1 {
    public static void main(String[] args) {
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