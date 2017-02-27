package com.chen.leetcode;

/**
 * Created by Chen on 2017/2/27.
 */
public class ZigZag {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (numRows >= s.length() || numRows == 1) {
            return s;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            int split = numRows * 2 - 2;
            sb.append(s.charAt(i));
            int j = 0;
            do {
                if (i != 0 && i != numRows - 1) {
                    int subSplit = split * (j + 1) - i;
                    if (subSplit < s.length()) {
                        sb.append(s.charAt(subSplit));
                    } else {
                        break;
                    }
                }
                int next = split * (j + 1) + i;
                if (next < s.length()) {
                    sb.append(s.charAt(next));
                } else {
                    break;
                }
                j++;
            } while (true);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ZigZag zigZag = new ZigZag();
        System.out.println(zigZag.convert("PAYPALISHIRING", 4));
    }
}
