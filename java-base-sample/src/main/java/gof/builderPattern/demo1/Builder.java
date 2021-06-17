/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package gof.builderPattern.demo1;

/**
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/11 10:36 <br>
 */
public interface Builder {
    Builder setEngine(Engine engine);
    Builder setWheel(String wheel);
    Builder setSeat(String seat);

    Vehicle build();


//    static Builder builder(){};
}
