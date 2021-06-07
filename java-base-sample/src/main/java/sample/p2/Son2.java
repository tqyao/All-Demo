package sample.p2;

public class Son2 extends Father{


    public void son2Fun() throws CloneNotSupportedException {
        Father father = new Father ();
//        father.grandFun (); //error 不同包下，不能通过基类实例访问基类protect方法
        father.faFun(); // faFun()方法对Father的子类和与Father同包下的类、方法可见

        this.grandFun ();
        this.faFun ();
    }
}
