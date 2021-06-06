/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package gof.practice.AbstractFactoryPattern;

/**
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/6 23:14 <br>
 */
public class GoogleFactory implements AbstractFactory {

    @Override
    public HtmlDocument createHtml(String md) {
        return new GoogleHtmlDocumentImpl(md);
    }

    @Override
    public WordDocument createWord(String md) {
        return new GoogleWordDocumentImpl(md);
    }
}
