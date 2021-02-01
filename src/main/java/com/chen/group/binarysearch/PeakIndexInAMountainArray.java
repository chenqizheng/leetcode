package com.chen.group.binarysearch;

public class PeakIndexInAMountainArray {

    public int peakIndexInMountainArray(int[] arr) {

        return peakIndexInMountainArray(arr, 0, arr.length - 1);
    }

    private int peakIndexInMountainArray(int[] arr, int l, int r) {
        if (l == r) {
            return l;
        }
        int mid = l + (r - l) / 2;
        if (arr[mid] < arr[mid + 1]) {
            return peakIndexInMountainArray(arr, mid + 1, r);
        } else {
            return peakIndexInMountainArray(arr, l, mid);
        }
    }
}
