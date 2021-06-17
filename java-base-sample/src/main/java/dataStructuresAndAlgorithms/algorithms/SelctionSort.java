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
 * @date Create in 2021/6/13 21:18 <br>
 */
public class SelctionSort {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 3, 7, 1};
        int[] sortArray = selctionSort(array);
        System.out.println(Arrays.toString(sortArray));
    }

    private static int[] selctionSort(int[] array) {
        int length = array.length;
        int[] newArray = new int[length];
        System.arraycopy(array, 0, newArray, 0, length);

        int minIndex, temp;
        for (int i = 0; i < length -1; i++) {
            minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (newArray[minIndex] > newArray[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = newArray[i];
                newArray[i] = newArray[minIndex];
                newArray[minIndex] = temp;
            }
        }
        return newArray;
    }
}
