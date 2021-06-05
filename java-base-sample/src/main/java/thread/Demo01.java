/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package thread;

import java.time.LocalDateTime;
import java.util.concurrent.*;

/**
 * .<br>
 * Future的使用
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/5/24 22:25 <br>
 */
public class Demo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 提交Callable任务后，会获得一个Future对象，在主线程某个时刻调用Future对象的get()方法
         * 就可以获得异步执行的结果。在调用get()时，如果异步任务已经完成，我们就直接获得结果。
         * 如果异步任务还没有完成，那么get()会阻塞，直到任务完成后才返回结果。
         *
         * 一个Future<V>接口表示一个未来可能会返回的结果，它定义的方法有：
         *
         * get()：获取结果（可能会等待）
         * get(long timeout, TimeUnit unit)：获取结果，但只等待指定的时间；
         * cancel(boolean mayInterruptIfRunning)：取消当前任务；
         * isDone()：判断任务是否已完成
         */
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        // 定义任务
        Callable<LocalDateTime> task = new Task();
        //提交任务并且获得 Future
        Future<LocalDateTime> future = executorService.submit(task);
        // 从 future 获取返回值结果
        System.out.println(future.get());
    }
}

/**
 * Callable接口是一个泛型接口，可以返回指定类型的结果。
 */
class Task implements Callable<LocalDateTime> {

    @Override
    public LocalDateTime call() throws Exception {
        return LocalDateTime.now();
    }
}
