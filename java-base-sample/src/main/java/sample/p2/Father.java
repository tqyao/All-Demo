package sample.p2;

import sample.p1.GrandFather;

public class Father extends GrandFather {

    protected String str = "father";

    protected GrandFather grandFather = new GrandFather ();

    protected void faFun() throws CloneNotSupportedException {
        System.out.println ("调用 Father method， 再调用：");

//        grandFather.grandFun (); error
//        grandFather.clone(); error
    }

//    public static void main(String[] args) throws CloneNotSupportedException {
//        Father father = new Father ();
//        father.grandFun ();
//    }
}
