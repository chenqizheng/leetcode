package com.chen.leetcode;

/**
 * Created by Chen on 2017/4/18.
 */
public class ExcelSheetTitile {

    public static void main(String[] args) {
        String s = new ExcelSheetTitile().convertToTitle(26);
        System.out.println(s);
    }

    public String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        do {
            int temp = (n - 1) % 26 ;
            char tempChar = (char) ('A' + temp);
            stringBuilder.append(tempChar);
            n = (n-1) / 26;
        } while (n >= 1);
        return stringBuilder.reverse().toString();

    }
}
