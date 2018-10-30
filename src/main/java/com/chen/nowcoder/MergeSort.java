package com.chen.nowcoder;

public class MergeSort {

    public static void main(String[] args) {
        sort(new int[]{6, 2, 4, 7, 8, 9, 3});
    }

    public static int[] sort(int[] array) {
        mergeSort(array, 0, array.length -1);
        return array;
    }

    public static void mergeSort(int[] array, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, high, mid);
        }
    }

    private static void merge(int[] array, int low, int high, int mid) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int p = 0;
        while (i <= mid && j <= high) {
            if (array[i] < array[j]) {
                temp[p++] = array[i++];
            } else {
                temp[p++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[p++] = array[i++];
        }

        while (j <= high) {
            temp[p++] = array[j++];
        }
        for (int q = 0; q < temp.length; q++) {
            array[q + low] = temp[q];
        }

        for (int item : array) {
            System.out.print(" " + item);
        }
        System.out.println();
    }
}
