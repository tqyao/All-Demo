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
public class GoogleWordDocumentImpl implements WordDocument {

    String md;

    public GoogleWordDocumentImpl(String md) {
        this.md = md;
    }

    @Override
    public String toWord(String md) {
        return "google word:" + md;
    }

    @Override
    public void save(String path) {
        System.out.println("google转换成功 md to word");
    }
}
