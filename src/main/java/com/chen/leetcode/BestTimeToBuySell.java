package com.chen.leetcode;

/**
 * Created by Chen on 2017/3/30.
 */
public class BestTimeToBuySell {
    public int maxProfit(int[] prices) {
        int result = 0;
        int[] temp = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            temp[i] = prices[i] - prices[i - 1];
        }

        for (int i : temp
                ) {
            if (i > 0) {
                result = result + i;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
