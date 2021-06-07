/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package gof.AbstractFactoryPattern;

/**
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/6 23:10 <br>
 */
public class AbstractFactoryClient {
    public static void main(String[] args) {
//        AbstractFactory fastFactory = new FastFactory();
//        HtmlDocument html = fastFactory.createHtml("# md格式");
//        html.save("xxx");
//        WordDocument word = fastFactory.createWord("# md格式文件");
//        word.save("xxx");
//
//        AbstractFactory googleFactory = new GoogleFactory();
//        HtmlDocument html2 = googleFactory.createHtml("# md格式");
//        html2.save("xxx");
//        WordDocument word2 = googleFactory.createWord("# md格式文件");
//        word2.save("xxx");

        AbstractFactory googleFactory = AbstractFactory.getFactoryInstance("google");
        WordDocument googleWordProduct = googleFactory.createWord("md");
        HtmlDocument googleHtmlProduct = googleFactory.createHtml(".md");
        googleWordProduct.save("xxx");
        googleHtmlProduct.save("xxx");

        AbstractFactory fastFactory = AbstractFactory.getFactoryInstance("fast");
        WordDocument fastWordProduct = fastFactory.createWord("md");
        HtmlDocument fastHtmlProduct = fastFactory.createHtml("md");
        fastWordProduct.save("xxx");
        fastHtmlProduct.save("xxx");

    }
}
