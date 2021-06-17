/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package dataStructuresAndAlgorithms.algorithms;

import java.util.Arrays;

/**
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/13 20:51 <br>
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 3, 7, 1};
        int[] sortArray = bubbleSort(array);
        System.out.println(Arrays.toString(sortArray));
    }

    private static int[] bubbleSort(int[] array) {
        int length = array.length;
        int[] newArray = new int[length];
        System.arraycopy(array, 0, newArray, 0, length);

        int temp;
        boolean flag = false;
        for (int i = length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (newArray[j] > newArray[j + 1]) {
                    temp = newArray[j];
                    newArray[j] = newArray[j + 1];
                    newArray[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return newArray;
    }
}
