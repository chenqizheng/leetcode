package com.chen.leetcode;

/**
 * Created by Chen on 2017/2/27.
 */
public class LongestPalindromicSubstring {

    private int index = 0;
    private int maxLenght = 0;

    /**
     * Question: 最长回文子串
     * Thinking:
     * 回文串问题 找到对称中轴串(奇数为一个字符,偶数为两个字符),用双指针法向两侧移动并判断
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(index, index + maxLenght);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLenght < k - j - 1) {
            maxLenght = k - j - 1;
            index = j + 1;
        }
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("babaab"));
    }
}