package com.chen.leetcode;

import java.util.Stack;

/**
 * Created by Chen on 2017/3/27.
 * <p>
 * herf:https://leetcode.com/problems/valid-parentheses/#/description
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {
            switch (c) {
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '(':
                    stack.push(')');
                    break;
                default:
                    if (stack.isEmpty() || c != stack.pop()) {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        validParentheses.isValid("s");
    }
}
