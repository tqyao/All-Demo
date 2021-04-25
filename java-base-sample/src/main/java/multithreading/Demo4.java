package multithreading;

/**
 * synchronized 线程同步问题
 */
public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new AddStudent ();
        Thread t2 = new DecStudent ();
        Thread t3 = new AddTeacher ();
        Thread t4 = new DecTeacher ();

        Thread[] threads = new Thread[]{t1, t2, t3, t4};

        for (Thread t : threads) {
            t.start ();
        }

        for (Thread t : threads) {
            t.join ();
        }

        System.out.println (Count.countStudent);
        System.out.println (Count.countTeacher);

    }

}

class Count {

    public static int countStudent = 0;
    public static int countTeacher = 0;

    public static final Object lock1 = new Object ();
    public static final Object lock2 = new Object ();
}

class AddStudent extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 10000; i++) {
            synchronized (Count.lock1) {
                Count.countStudent += 1;
            }
        }
    }
}

class DecStudent extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 10000; i++) {
            synchronized (Count.lock1) {
                Count.countStudent -= 1;
            }
        }
    }
}

class AddTeacher extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 10000; i++) {
            synchronized (Count.lock2) {
                Count.countTeacher += 1;
            }
        }
    }
}

class DecTeacher extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 10000; i++) {
            synchronized (Count.lock2) {
                Count.countTeacher -= 1;
            }
        }
    }
}
