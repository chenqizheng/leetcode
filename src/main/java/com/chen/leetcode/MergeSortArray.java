package com.chen.leetcode;

public class MergeSortArray {


    public static void main(String[] args) {
        int[] result = new int[]{
                4, 0, 0, 0, 0, 0, 0
        };
        new MergeSortArray().merge(result, 1, new int[]{1, 2, 3, 5, 6}, 5);
        System.out.println(result);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = 0;
        int q = 0;

        while (p < m + q && q < n) {
            if (nums1[p] < nums2[q]) {
                p++;
            } else {
                for (int j = m + q; j > p; j--) {
                    nums1[j] = nums1[j - 1];
                }
                nums1[p] = nums2[q];
                q++;
                p++;
            }
        }
        while (q < n) {
            nums1[p] = nums2[q];
            q++;
            p++;
        }
    }
}
