/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package gof.practice.AbstractFactoryPattern;

/**
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/6 23:04 <br>
 */
public class FastHtmlDocumentImpl implements HtmlDocument {

    //要转换的md
    private String md;

    public FastHtmlDocumentImpl(String md){
        this.md = md;
    }

    @Override
    public String toHtml(String md) {
        return "HTML：" + md;
    }

    @Override
    public void save(String path) {
        System.out.println("Fast保存HTML文件成功！");
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }
}
