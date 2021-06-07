package sample.p1;

public class GrandFather {

    protected void grandFun() throws CloneNotSupportedException {
        System.out.println ("调用grand fun method");
        Object clone = this.clone ();
    }
}
