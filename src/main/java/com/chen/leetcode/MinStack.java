package com.chen.leetcode;

import java.util.Stack;

public class MinStack {

    /**
     * initialize your data structure here.
     */

    private Stack<Integer> minStack;
    private Stack<Integer> data;

    public MinStack() {
        minStack = new Stack<Integer>();
        data = new Stack<Integer>();
    }

    public void push(int x) {
        data.push(x);
        if (minStack.empty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(minStack.peek(), x));
        }
    }

    public void pop() {
        data.pop();
        minStack.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
