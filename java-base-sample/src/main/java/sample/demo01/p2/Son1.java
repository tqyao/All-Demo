/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package sample.demo01.p2;

import sample.demo01.p1.Father;

/**
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/14 17:13 <br>
 */
public class Son1 extends Father {
    public void sonFun(){
//        this.faFun01Default();
//        this.faFun02Private();

        this.faFun03Protect();
        this.faFun04Public();
    }
}
