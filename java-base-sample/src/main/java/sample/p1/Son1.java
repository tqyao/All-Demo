package sample.p1;

import sample.p2.Father;

public class Son1 extends Father {

    // protected：子类和基类在不同包中，子类可以访问从基类继承而来的方法，而不能访问基类实例的protect方法
    public void son1Fun() throws CloneNotSupportedException {
        Father father = new Father ();  //基类实例
        father.grandFun (); // 与GrandFather同包，所以可以访问GrandFather的protected方法
//        father.faFun(); //error 不能访问基类protect方法

        this.grandFun ();
        this.faFun ();
    }


//    public static void main(String[] args) throws CloneNotSupportedException {
//        Son1 son1 = new Son1 ();
//        son1.grandFun ();
//        son1.faFun ();
//
//        Father father = new Father ();
//        father.grandFun ();
////        father.faFun(); //error
//    }

}
