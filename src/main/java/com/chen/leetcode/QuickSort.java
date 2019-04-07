
package com.chen.leetcode;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{7, 5, 2, 4, 1, 8, 9, 6};

        new QuickSort().solution(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public void solution(int[] array, int low, int high) {
        if (low > high) {
            return;
        }
        int i = low;
        int j = high;
        int temp = array[low];
        while (i < j) {
            while (temp < array[j] && i < j) {
                j--;
            }
            while (temp > array[i] && i < j) {
                i++;
            }

            if (i < j) {
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }
        array[low] = array[i];
        array[i] = temp;
        solution(array, low, j - 1);
        solution(array, j + 1, high);
    }
}
