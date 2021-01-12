package com.chen.group.tree.traversal;

import java.util.HashMap;

import com.chen.model.TreeNode;

/**
 * https://leetcode.com/problems/path-sum-iii/
 */
public class PathSum3 {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSumMap = new HashMap<Integer, Integer>();
        preSumMap.put(0, 1);
        return helper(root, 0, sum, preSumMap);
    }

    private int helper(TreeNode root, int currentSum, int target, HashMap<Integer, Integer> preSumMap) {
        if (root == null) {
            return 0;
        }
        currentSum += root.val;
        int res = 0;
        Integer resInteger = preSumMap.get(currentSum - target);
        if (resInteger != null) {
            res = resInteger;
        }
        int res1 = 0;
        Integer resInteger1 = preSumMap.get(currentSum);
        if (resInteger1 != null) {
            res1 = resInteger1;
        }
        preSumMap.put(currentSum, res1 + 1);

        res += helper(root.left, currentSum, target, preSumMap) + helper(root.right, currentSum, target, preSumMap);

        preSumMap.put(currentSum, preSumMap.get(currentSum) - 1);

        return res;
    }
}
