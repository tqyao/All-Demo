/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package gof.practice.AbstractFactoryPattern;

/**
 * 抽象产品
 * .<br>
 * 产品功能复杂，现在还不知到如何实现，定义抽象接口
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/6 22:56 <br>
 */
public interface WordDocument {

    String toWord(String md);

    void save(String path);
}
