package com.chen.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Chen on 2017/3/28.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        List<String> list1 = new ArrayList<String>();
        eachTree(list, "", 0, 0, n);
        return list1;
    }

    private void eachTree(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }
        if (open < max) {
            eachTree(list, str + '(', open + 1, close, max);
        }
        if (close < open) {
            eachTree(list, str + ')', open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        new GenerateParentheses().generateParenthesis(3);
    }
}
