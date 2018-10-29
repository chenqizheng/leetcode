package com.chen.nowcoder;

public class InsertSort {
    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int current = array[i];
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
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
