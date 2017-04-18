package com.chen.leetcode;

/**
 * Created by Chen on 2017/4/18.
 */
public class ReverseString {
    public String reverseString(String s) {
        char[] c = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            c[i] = s.charAt(s.length() - i - 1);
        }
        return new String(c);
    }

    public static void main(String[] args) {
        String s = new ReverseString().reverseString("hello");
        System.out.println(s);
    }
}
