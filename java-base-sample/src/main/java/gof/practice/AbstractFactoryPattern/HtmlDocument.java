/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package gof.practice.AbstractFactoryPattern;

/**
 * 抽象产品
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/6 22:56 <br>
 */
public interface HtmlDocument {


    String toHtml(String md);

    void save(String path);
}
