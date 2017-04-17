package com.chen.leetcode;

/**
 * 最大长度的积
 * href: https://leetcode.com/problems/maximum-product-of-word-lengths/#/description
 * Created by Chen on 2017/4/14.
 */
public class MaximumProductOfWordList {
    public int maxProduct(String[] words) {
        int max = 0;
        int length = words.length;
        int[][] list = new int[length][];
        for (int i = 0; i < length; i++) {
            int[] count = new int[27];
            for (char c : words[i].toCharArray()) {
                count[c - 'a'] = 1;
            }
            count[26] = words[i].length();
            list[i] = count;
        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                boolean isValid = true;
                for (int p = 0; p < 26; p++) {
                    if (list[i][p] + list[j][p] >= 2) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    int temp = list[i][26] * list[j][26];
                    if (max < temp) {
                        max = temp;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String[] strArray = new String[]{"a", "aa", "aaa", "aaaa"};
        int max = new MaximumProductOfWordList().maxProduct(strArray);
        System.out.println("max = " + max);
    }
}
