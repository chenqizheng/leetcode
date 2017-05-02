package com.chen.leetcode;

/**
 * Created by Chen on 2017/4/27.
 */
public class PowerNumber {

    public boolean power2(int number) {
        return number > 0 && ((number & (number - 1)) == 0);
    }

    public boolean power3ByLog(int number) {
        double x = Math.log10(number) / Math.log10(3);
        return x - (int) x == 0;
    }

    public boolean power4(int number) {
        return number > 0 && ((number & (number - 1)) == 0) && (number - 1) % 3 == 0;
    }

    public static void main(String[] args) {
        System.out.println("result = " + new PowerNumber().power2(8));
        System.out.println("result = " + new PowerNumber().power4(16));
        System.out.println("result = " + new PowerNumber().power3ByLog(96));
    }
}
