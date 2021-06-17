/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package gof.builderPattern;

import java.util.HashMap;

/**
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/7 23:42 <br>
 */
public class URLBuilderClient {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>(){{
            put("a", "123");
            put("q","K&R");
        }};
        String builder = new URLBuilder.Builder()
                .setDoMain("www.liaoxuefeng")
                .setScheme("https")
                .setPath("/")
                .setQuery(map)
                .builder();
        System.out.println(builder);
    }
}
