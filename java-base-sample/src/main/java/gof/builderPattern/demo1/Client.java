/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package gof.builderPattern.demo1;

/**
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/11 11:35 <br>
 */
public class Client {
    public static void main(String[] args) {
        BWMCat build = (BWMCat) BWMBuilder.builder()
                .setEngine(new Engine("德国engine",1000.00))
                .setSeat("真牛皮座位")
                .setWheel("泰国天然胶轮子")
                .build();

        build.run();
    }
}
