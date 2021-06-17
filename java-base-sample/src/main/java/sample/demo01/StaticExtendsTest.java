/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package sample.demo01;

/**
 * 父类中的静态属性方法可以被继承，不能被重写（override），而是被隐藏
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/14 18:13 <br>
 */
public class StaticExtendsTest {
    public static void main(String[] args) {
        FatherTest01 fatherTest01 = new SonTest01();    //子类向上转型
        System.out.println(fatherTest01.staticAttributeFather);
        fatherTest01.staticFatherFun();
        fatherTest01.staticFatherFun2();
        System.out.println("==========================");

        /**
         * 父子类中子类表面上重写了父类的静态成员，父子类中重写的静态成员在父子类之间是相互屏蔽的，毫无关系的，不存在重写方法的动态绑定。
         */
        SonTest01 sonTest01 = new SonTest01();
        System.out.println(sonTest01.staticAttributeFather);
        sonTest01.staticFatherFun();    // 由于子类存在与父类同名的静态方法，父类的被隐藏掉（）
        sonTest01.staticFatherFun2();   // 子类中未找到该静态方法，则调用从父类继承而来的静态方法（表明静态方法是可以被继承的）
    }
}
