package com.chen.leetcode;

/**
 * Created by Chen on 2017/3/3.
 */
public class PowXN {

    public double myPow(double x, int n) {
        if (x == 1) return 1;
        if (x == -1) return n % 2 == 0 ? 1 : -1;
        if (n == Integer.MIN_VALUE) return 0;
        if (n == 0)
            return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        PowXN powXN = new PowXN();
        System.out.println(powXN.myPow(2, -2147483648));
    }
}
