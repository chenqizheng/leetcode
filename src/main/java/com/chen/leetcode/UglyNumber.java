package com.chen.leetcode;

/**
 * Created by Chen on 2017/4/27.
 */
public class UglyNumber {


    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;
        int count = 1;
        while (count < n) {
            int resultX2 = 2 * uglyNumbers[idx2];
            int resultX3 = 3 * uglyNumbers[idx3];
            int resultX5 = 5 * uglyNumbers[idx5];

            int min = Math.min(resultX5, Math.min(resultX3, resultX2));
            if (min == resultX2) {
                idx2++;
            }
            if (min == resultX3) {
                idx3++;
            }
            if (min == resultX5) {
                idx5++;
            }
            uglyNumbers[count] = min;
            count++;
        }
        return uglyNumbers[n - 1];
    }

    public static void main(String[] args) {
        int number = new UglyNumber().nthUglyNumber(7);
        System.out.println("number =  " + number);
    }
}
