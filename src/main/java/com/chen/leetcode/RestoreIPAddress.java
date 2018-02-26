package com.chen.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
    public static List<String> restoreIpAddresses(String s) {
        List<String> target = new ArrayList<String>();
        if(s == null || s.length() == 0) {
            return target;
        }
        for (int i = 1; i < 4; i++) {
            for (int j = i + 1; j < i + 4; j++) {
                for (int k = j + 1; k < j + 4; k++) {
                    int temp = s.length() - k;
                    if (temp > 0 && temp < 4) {
                        String s1 = s.substring(0, i);
                        String s2 = s.substring(i, j);
                        String s3 = s.substring(j, k);
                        String s4 = s.substring(k, s.length());
                        if (isVaild(s1) && isVaild(s2) && isVaild(s3) && isVaild(s4)) {
                            target.add(s1 + "." + s2 + "." + s3 + "." + s4);
                        }
                    }
                }
            }
        }
        return target;
    }

    public static boolean isVaild(String s) {
        try {
            int temp = Integer.parseInt(s);
            if (s.length() > 1 && s.toCharArray()[0] == '0') {
                return false;
            }
            if (temp >= 0 && temp <= 255) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("0000"));
    }
}
