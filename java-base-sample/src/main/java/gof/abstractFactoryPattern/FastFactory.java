/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package gof.abstractFactoryPattern;

/**
 * 由于产品实现困难决定由第三方供应商提供服务，由供应商创建抽象工厂实现生产第三方的产品
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/6 23:01 <br>
 */
public class FastFactory implements AbstractFactory {

    @Override
    public HtmlDocument createHtml(String md) {
        return new FastHtmlDocumentImpl(md);
    }

    @Override
    public WordDocument createWord(String md) {
        return new FastWordDocumentImpl(md);
    }
}
