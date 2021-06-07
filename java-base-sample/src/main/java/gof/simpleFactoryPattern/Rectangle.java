/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package gof.simpleFactoryPattern;

/**
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/6 19:29 <br>
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("长方形");
    }
}
