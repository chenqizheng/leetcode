package com.chen.nowcoder;

public class BubbleSort {
    public static int[] sort(int[] array) {
        if (array == null) {
            return null;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] result = sort(new int[]{5, 2, 7, 3, 9, 0, 1, 4, 6});
        for (int item : result) {
            System.out.print(" " + item);
        }
    }
}
