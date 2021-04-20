package multithreading;

import javax.swing.text.html.HTMLWriter;

/**
 * 线程中断
 * 1.interrupt()方法，只是调用线程（main t1.interrupt（））向目标线程（t线程）发出“中断请求”，是否立刻响应，要看具体代码。
 * 2.处于等待状态（例t1 helloThread.join ()）的线程，如果其它线程（如main线程）对其调用interrupt()，其join方法会立刻 \
 * 抛出InterruptedException，通常情况下该线程应该立刻结束
 */
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new MyThread ();
        t1.start ();
        t1.interrupt ();
        t1.join (); // 等待t线程结束
        System.out.println ("main end.");

        // ---------------------------------
        //另一个常用的中断线程的方法是设置标志位。
        HelloThead2 t2 = new HelloThead2 ();
        t2.start ();
        Thread.sleep(1);
        t2.running = false;

    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        Thread helloThread = new HelloThread ();
        helloThread.setName ("HelloThread:");
        helloThread.start ();
        try {
            helloThread.join ();
        } catch (InterruptedException e) {
            // MyThread线程收到其它线程的终止命令，MyThread的join方法会立刻抛出InterruptedException
            System.out.println ("MyThread捕获终止异常");
        }
        // 发送终止请求
        helloThread.interrupt ();
    }
}

class HelloThread extends Thread {

    @Override
    public void run() {
        int n = 0;
        while (isInterrupted ()) {
            n++;
            System.out.println (Thread.currentThread ().getName () + "say hello");
            try {
                Thread.sleep (1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

class HelloThead2 extends Thread {


    // volatile:当一个线程修改了某个共享变量的值，其他线程能够立刻看到修改后的值
    //每次访问变量时，总是获取主内存的最新值；
    //每次修改变量后，立刻回写到主内存。
    public volatile boolean running = true;

    @Override
    public void run() {
        int n =0;
        while (running) {
            n++;
            System.out.println (n + "hello!");
        }
        System.out.println ("end！");
    }
}