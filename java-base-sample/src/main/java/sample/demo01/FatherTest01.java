/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package sample.demo01;

/**
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/14 17:08 <br>
 */
public abstract class FatherTest01 {
    //无法抽象方法无法声明为私有
//    private abstract void fun01();

    public static String staticAttributeFather = "staticAttributeFather：父类静态属性";
    public  String attributeFather = "attributeFather：父类属性";

    public void fatherFun(){
        System.out.println("fatherFun():父类方法打印");
    }

    public static void staticFatherFun(){
        System.out.println("staticFatherFun():父类静态方法打印");
    }

    public static void staticFatherFun2(){
        System.out.println("staticFatherFun2():父类静态方法打印");
    }
}
