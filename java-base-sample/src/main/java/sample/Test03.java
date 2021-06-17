/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package sample;

/**
 * 字符串常量池
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/9 21:08 <br>
 */
public class Test03 {
    public static void main(String[] args) {
        String a = "hello"; //在常量池中创建一个对象
        /**
         * 1. 查找常量池是否存在 hello
         * - 不存在，创建 hello 常量对象
         * - 存在返回对应实例引用
         * 2.  在堆中new 一个new String("hello")对象
         * 3. 在栈中创建一个指向对象地址的一个引用
         */
        String b = new String("hello");
        System.out.println(a == b);

    }
}
