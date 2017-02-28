package com.chen.leetcode;

/**
 * Created by Chen on 2017/2/28.
 */
public class StringToInt {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        int result = 0;
        int sign = 1;
        int start = 0;
        if (str.charAt(0) == '+') {
            sign = 1;
            start = 1;
        } else if (str.charAt(0) == '-') {
            sign = -1;
            start = 1;
        }
        for (int i = start; i < str.length(); i++) {
            int number = str.charAt(i) - '0';
            if (number > 9 || number < 0) {
                break;
            }
            result = result * 10 + number;
            if (result > Integer.MAX_VALUE || result <= Integer.MIN_VALUE &&  Integer.MAX_VALUE %10  <  number) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return result * sign;
    }


    public static void main(String[] args) {
        StringToInt stringToInt = new StringToInt();
        stringToInt.myAtoi("-2147483649");
    }
}
