/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package gof.strategy;

import java.util.Arrays;

/**
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/12 12:13 <br>
 */
public class Demo01 {
    public static void main(String[] args) {
        String[] array = { "apple", "Pear", "Banana", "orange" };
        Arrays.sort(array, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(array));

        Arrays.sort(array, String::compareTo);
        System.out.println(Arrays.toString(array));

    }
}
