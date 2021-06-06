/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package gof.practice.simpleFactoryPattern;

/**
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/6 19:31 <br>
 */
public class ShapeFactory {

    static Shape getShapeInstance(Type type) {
        switch (type) {
            case Circle:
                return new Circle();
            case Square:
                return new Square();
            case Rectangle:
                return new Rectangle();
            default:
                return null;
        }
    }

    enum Type {
        Circle,
        Rectangle,
        Square
    }


}
