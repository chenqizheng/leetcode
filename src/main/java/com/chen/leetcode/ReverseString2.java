package com.chen.leetcode;

public class ReverseString2 {
    public String reverseWords(String s) {
        s = s.trim();
        s = reverseString(s);
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if(words[i].length() ==0) {
                continue;
            }
            sb.append(reverseString(words[i]));
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }


    public String reverseString(String s) {
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(s.length() - i - 1);
        }
        return new String(chars);
    }

}
