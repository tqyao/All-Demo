/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package gof.practice.simpleFactoryPattern;

/**
 * 简单工程模式
 * 工厂模式（Factory Pattern）是 Java 中最常用的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/6 22:23 <br>
 */
public class ShapeFactoryDemo {
    public static void main(String[] args) {
        Shape shapeInstance = ShapeFactory.getShapeInstance(ShapeFactory.Type.Circle);
        shapeInstance.draw();
    }
}
