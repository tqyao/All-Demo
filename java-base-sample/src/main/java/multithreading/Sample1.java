package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sample1 {
    public static void main(String[] args) {
//        for (int i = 0; i < 2; i++) {
//            new Customer ().start ();
//        }

        new Customer ().start ();
        new Customer ().start ();

        new Producer ().start ();
    }
}

class Bao {
    public static final Lock lock = new ReentrantLock ();
    public static final Condition condition = lock.newCondition ();
    // 包子数量
    public static int count = 100;
}

class Customer extends Thread {

    @Override
    public void run() {
        Bao.lock.lock ();
        try {
            while (true) {
                if (Bao.count == 0) {
                    Bao.condition.await ();
                }
                System.out.println (Thread.currentThread ().getName () + "号客人吃包子，剩余数量数量：" + (--Bao.count));
//                Thread.sleep (1000);
                Bao.condition.await ();
            }
        } catch (InterruptedException e) {
            e.printStackTrace ();
        } finally {
            Bao.lock.unlock ();
        }
    }
}


class Producer extends Thread {

    @Override
    public void run() {
        Bao.lock.lock ();
        try {
            while (Bao.count == 0) {
                System.out.println ("新鲜包子出炉咯，快来抢啊,剩余包子数量" + (++Bao.count));
                Bao.condition.signalAll ();
                Thread.sleep (2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace ();
        } finally {
            Bao.lock.unlock ();
        }
    }
}