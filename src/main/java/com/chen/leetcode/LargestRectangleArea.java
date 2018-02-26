package com.chen.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleArea {
    public static final void main(String[] args) {
        largestRectangleArea2(new int[]{2, 1, 5, 6, 2, 3});
    }

    public static int largestRectangleArea2(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        while (i < h.length) {
            if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
}
