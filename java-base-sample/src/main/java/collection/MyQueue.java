package collection;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 队列Queue实现了一个先进先出（FIFO）的数据结构：
 *
 * 通过add()/offer()方法将元素添加到队尾；
 * 通过remove()/poll()从队首获取元素并删除；
 * 通过element()/peek()从队首获取元素但不删除。
 * 要避免把null添加到队列。
 */
public class MyQueue {
    public static void main(String[] args) {
        //LinkedList 实现了List也实现了Queue
        List<Object> list = new LinkedList<> ();
        Queue<Object> queue = new LinkedList<> ();

        try {
            queue.add ("aaa"); // 添加，可能会抛出异常
            queue.element (); // 取出队首但不删除
            queue.remove ("aaa"); //取出删除
        } catch (Exception e) {
            e.printStackTrace ();
        }

        queue.offer ("bbb"); // boolean
        Object peek = queue.peek (); // 取出队首但不删除（查看）
        Object poll = queue.poll ();// 取出队首删除，可能返回null；

        LinkedList<String> ll = new LinkedList<> ();
        ll.add ("aaa");
        ll.addLast ("bbb");

    }
}
