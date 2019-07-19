package com.chen.leetcode;

public class PrimeCount {

    public int countPrimes(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 0;
        } else if (n == 3) {
            return 1;
        }

        int[] result = new int[n];
        result[0] = 1;
        result[1] = 1;
        result[2] = 0;
        result[3] = 0;
        for (int i = 2; i < n; i++) {
            for (int j = 2; i * j < n; j++) {
                result[i * j] = 1;
            }
        }

        int count = 0;
        for (int i : result) {
            if (i == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        new PrimeCount().countPrimes(3);
    }
}
