package com.chen.leetcode;

/**
 * Created by Chen on 2017/1/21.
 */
public class Power {
    public static void main(String[] args) {
        System.out.println(power(10, 6));
    }

    public static double power(int x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        }
        double result = power(x, n / 2);
        if (n % 2 == 0) {
            return result * result;
        } else {
            return result * result * x;
        }
    }
}
