/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package sample.demo01;

/**
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/14 18:00 <br>
 */
public class SonTest01 extends FatherTest01 {

    public static String staticAttributeFather = "staticAttributeFather：子类静态属性";
    public  String attributeFather = "attributeFather：子类属性";

    public static void staticFatherFun(){
        System.out.println("staticFatherFun():子类静态方法打印");
    }
}
