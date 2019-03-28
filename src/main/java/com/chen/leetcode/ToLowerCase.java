package com.chen.leetcode;

public class ToLowerCase {
    public String toLowerCase(String str) {

        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                result[i] = (char) (c + 'a' - 'A');
            } else {
                result[i] = c;
            }
        }
        return new String(result);
    }
}
