package com.chen.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    //递归
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        handle(lists, list, k, n, 1);
        return lists;
    }

    private void handle(List<List<Integer>> lists, List<Integer> list, int k, int n, int start) {
        if (list.size() == k) {
            if (n == 0) {
                lists.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for (int i = start; i < 10; i++) {
            list.add(i);
            handle(lists, list, k, n - i, i + 1);
            list.remove(new Integer(i));
        }
    }


    public static void main(String[] args) {
        System.out.println(new CombinationSum3().combinationSum3(3, 9));
    }
}
