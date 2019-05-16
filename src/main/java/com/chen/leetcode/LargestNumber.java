package com.chen.leetcode;

import java.util.*;

public class LargestNumber {

    public static void main(String[] args) {
        new LargestNumber().largestNumber(new int[]{2, 10});
    }

    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<String>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        });
        StringBuilder sb = new StringBuilder();

        if (list.get(0).equals("0")) {
            return "0";
        }
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }
}
