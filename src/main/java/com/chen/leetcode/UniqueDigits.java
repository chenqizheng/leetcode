package com.chen.leetcode;

/**
 * Created by Chen on 2017/4/18.
 */
public class UniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        int val = 9, ans = 10;
        for (int i = 2; i <= n; i++) {
            val *= (9 - i + 2);
            ans += val;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new UniqueDigits().countNumbersWithUniqueDigits(3));
    }
}
