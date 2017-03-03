package com.chen.leetcode;

/**
 * Created by Chen on 2017/3/3.
 */
public class PowXN {
    public double myPow(double x, int n) {
        if (n == 1) {
            return x;
        } else if( n == 0 ) {
            return 1;
        } else {
            double temp = myPow(x, n / 2);
            if (n % 2 == 0) {
                return temp * temp;
            } else {
                return temp * temp * x;
            }
        }
    }

    public static void main(String[] args) {
        PowXN powXN = new PowXN();
        System.out.println(powXN.myPow(2, 3));
    }
}
