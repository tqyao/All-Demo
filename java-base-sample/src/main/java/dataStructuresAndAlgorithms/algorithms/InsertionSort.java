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
 * @date Create in 2021/6/13 11:07 <br>
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 3, 7, 1};
        int[] sortArray = insertSort(array);
        System.out.println(Arrays.toString(sortArray));
    }

    private static int[] insertSort(int[] array) {
        int length = array.length;
        int[] newArray = new int[length];
        System.arraycopy(array, 0, newArray, 0, length);

        int temp;
        for (int i = 1; i < length; i++) {
            int j = i;
            // 记录未排序的数组中准备排序的元素值
            temp = newArray[j];
            // j -1 > 0 排除数组越界， temp < newArray[j - 1] ：待排序元素依次与已排序元素比较
            while (j - 1 >= 0 && temp < newArray[j - 1]) {
                // 待排序元素小于已排序元素，让出自己的位置，
                newArray[j] = newArray[j - 1];
                j--;
            }

            // 如果i != j ：说明发生了交换
            if (i != j) {
                newArray[j] = temp;
            }
        }

        return newArray;
    }
}
