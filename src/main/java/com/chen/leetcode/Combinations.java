package com.chen.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
        solution(results, new ArrayList<Integer>(), 1, n, k);
        return results;
    }

    private void solution(ArrayList<List<Integer>> results, ArrayList<Integer> result, int start, int n, int k) {
        if (k == 0) {
            results.add(new ArrayList<Integer>(result));
        } else {
            for (int i = start; i <= n; i++) {
                result.add(i);
                solution(results, result, i + 1, n, k - 1);
                result.remove(result.size() - 1);
            }
        }
    }
}
