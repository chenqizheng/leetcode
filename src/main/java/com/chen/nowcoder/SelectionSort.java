package com.chen.nowcoder;

public class SelectionSort {
    public static int[] sort(int[] array) {
        if (array == null) {
            return null;
        }
        for (int i = 0; i < array.length; i++) {
            int flag = i;
            for (int j = i; j < array.length; j++) {
                if(array[flag] > array[j]) {
                    flag = j;
                }
            }
            int temp = array[flag];
            array[flag] = array[i];
            array[i] = temp;
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
