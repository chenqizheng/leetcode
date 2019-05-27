package com.chen.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode:https://leetcode.com/problems/remove-invalid-parentheses/
 */
public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        List<String> ret = new ArrayList<>();
        List<String> tempArray = new ArrayList<>();

        tempArray.add(s);
        while (!tempArray.isEmpty()) {
            for (String temp : tempArray
                    ) {
                if (isValid(temp)) {
                    ret.add(temp);
                }
            }
            if (!ret.isEmpty()) {
                return ret;
            }
            List<String> nextLevel = new ArrayList<>();

            for (String temp : tempArray
                    ) {
                for (int i = 0; i < temp.length(); i++) {
                    if (temp.charAt(i) == '(' || temp.charAt(i) == ')') {
                        String sub = temp.substring(0, i) + temp.substring(i + 1);
                        if (!nextLevel.contains(sub)) {
                            nextLevel.add(sub);
                        }
                    }
                }
            }
            tempArray = nextLevel;
        }
        if (ret.size() == 0) {
            ret.add("");
        }
        return ret;
    }

    public boolean isValid(String s) {
        if (s == null || s.equals("")) {
            return false;
        }
        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stack.empty()) {
                    return false;
                } else if (stack.pop() != '(') {
                    return false;
                }
            }
        }

        return stack.empty();
    }


    public static void main(String[] args) {
        RemoveInvalidParentheses list = new RemoveInvalidParentheses();
        List<String> result = list.removeInvalidParentheses("()())()");
        for (String s : result
                ) {
            System.out.println(s);
        }
    }
}
