package com.chen.leetcode;

import jdk.nashorn.internal.objects.annotations.Where;

/**
 * Created by Chen on 2017/3/3.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        boolean result = true;
        int count = 0;
        int temp = x;
        do {

            temp = temp / 10;
            count++;
            if (temp < 1) {
                break;
            }
        } while (true);
        for (int i = 0; i <= count / 2; i++) {

            int number = ((int) (x / Math.pow(10, i))) % 10;
            int number2 = ((int) (x / Math.pow(10, count - i - 1))) % 10;
            result = result && number == number2;
        }
        return result;
    }

    public static void main(String[] args) {
        PalindromeNumber number = new PalindromeNumber();
        System.out.println(number.isPalindrome(-2147483648));
    }
}
