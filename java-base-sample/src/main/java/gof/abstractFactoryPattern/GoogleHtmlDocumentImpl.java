/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package gof.abstractFactoryPattern;

/**
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/6 23:14 <br>
 */
public class GoogleHtmlDocumentImpl implements HtmlDocument {

    String md;

    public GoogleHtmlDocumentImpl(String md) {
        this.md = md;
    }

    @Override
    public String toHtml(String md) {
        return "google html" + md;
    }

    @Override
    public void save(String path) {
        System.out.println("google转换成功 md to html");
    }
}
