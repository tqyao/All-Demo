/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package gof.abstractFactoryPattern;

/**
 * 抽象工厂模式
 * .<br>
 *
 * 需求：提供一个Markdown文本转换为HTML和Word的服务
 *
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/6 22:45 <br>
 */
public interface AbstractFactory {  // 抽象工厂

    /**
     * 产品抽象
     * 创建 html文档 抽象产品
     * @return
     */
    HtmlDocument createHtml(String md);

    /**
     * 产品抽象
     * 创建word文档 抽象产品
     * @param md
     * @return
     */
    WordDocument createWord(String md);


    static AbstractFactory getFactoryInstance(String type){
        if ("google".equals(type)) {
            return new GoogleFactory();
        }
        if ("fast".equals(type)) {
            return new FastFactory();
        }
        return null;
    }


}
