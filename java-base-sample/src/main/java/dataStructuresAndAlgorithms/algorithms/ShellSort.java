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
 * @date Create in 2021/6/13 11:55 <br>
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 3, 7, 1};
//        int[] sortArray = shellSort(array);
//        System.out.println(Arrays.toString(sortArray));

        Integer[] array2 = {5, 4, 3, 3, 7, 1};
        shellSort2(array2);
        System.out.println(Arrays.toString(array2));
    }

    private static int[] shellSort(int[] array) {
        int length = array.length;
        int[] newArray = new int[length];
        System.arraycopy(array, 0, newArray, 0, length);

        int z = length / 2;
        int temp;
        while (z != 0) {
            for (int i = z; i < length; i++) {
                temp = newArray[i];
                int j = i;
                while (j - z >= 0 && temp < newArray[j - z]) {
                    newArray[j] = newArray[j - z];
                    j -= z;
                }
                if (j != i) {
                    newArray[j] = temp;
                }
            }
            z = z/2;
        }
        return newArray;
    }

    private static void shellSort2(Comparable[] arr) {
        int j;
        for (int gap = arr.length / 2; gap >  0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                Comparable tmp = arr[i];
                for (j = i; j >= gap && tmp.compareTo(arr[j - gap]) < 0; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = tmp;
            }
        }
    }

}
