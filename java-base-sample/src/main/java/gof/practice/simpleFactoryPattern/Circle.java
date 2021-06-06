/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package gof.practice.simpleFactoryPattern;

/**
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/6 19:28 <br>
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("画个圈圈祝福你");
    }
}
