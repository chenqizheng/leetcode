package com.chen.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Chen on 2017/2/28.
 */
public class ReverseInterger {


    public int reverse(int x) {
        if(x == Integer.MIN_VALUE){
            return 0;
        }
        int count = 0;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        boolean isminus = x < 0;
        int target = Math.abs(x);
        do {
            count++;
            int i = target % 10;
            arrayList.add(i);
            target = target / 10;
            if (target < 1) {
                break;
            }
        } while (true);
        int result = 0;
        for (Integer i : arrayList
                ) {
            double temp = (result + i * Math.pow(10, count - 1));
            if (temp > Integer.MAX_VALUE) {
                return 0;
            } else {
                result = (int) temp;
            }
            count--;
        }
        if (isminus) {
            return 0 - result;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        ReverseInterger reverseInterger = new ReverseInterger();
        int result = reverseInterger.reverse(-2147483648);
        System.out.println("result = " + result);
    }
}
