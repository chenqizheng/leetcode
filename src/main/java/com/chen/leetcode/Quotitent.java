package com.chen.leetcode;

public class Quotitent {
    public int solution(int num1, int num2) {
        int count = 0;
        if (num1 < num2) {
            return 0;
        }
        int temp = num2;
        while (num1 >= temp) {
            temp = temp << 1;
            count++;
        }
        if ((temp >> 1) > num1) {
            return (count << 1) + 1;
        } else {
            return (count << 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Quotitent().solution(12, 2));

    }
}
