package multithreading;

/**
 * 线程的去启动方式
 */
public class Demo1 {
    public static void main(String[] args) {
        // 线程的启动方式
        // 方式一
        Thread t1 = new T1();
        // 方式二
        Thread t2 = new Thread (new T2 ());



        Thread t3 = new Thread (()-> {
            try {
                Thread.sleep (10);  // 让线程睡眠10毫秒
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            Thread.currentThread ().setName ("T3");
            System.out.println (Thread.currentThread ().getName ());
        });

        t1.start ();
        t2.start ();
        t3.start ();

    }
}

class T1 extends Thread{


    @Override
    public void run() {
        Thread.currentThread ().setName ("T1");
        System.out.println (Thread.currentThread ().getName ());
    }
}

class T2 implements Runnable{

    @Override
    public void run() {
        Thread.currentThread ().setName ("T2");
        System.out.println (Thread.currentThread ().getName ());
    }
}