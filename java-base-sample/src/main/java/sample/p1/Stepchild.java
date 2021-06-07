package sample.p1;

import sample.p2.Father;

public class Stepchild {

    public void stepFun() throws CloneNotSupportedException {
        Father father = new Father ();
        father.grandFun ();
//        father.faFun(); //error

    }
}
