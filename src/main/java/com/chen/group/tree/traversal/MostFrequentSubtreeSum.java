package com.chen.group.tree.traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.chen.model.TreeNode;

public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> sumOfCount = new HashMap<Integer, Integer>();
        dfs(root, sumOfCount);
        Set<Integer> keys = sumOfCount.keySet();
        List<Integer> values = new ArrayList<Integer>();
        for(Integer key : keys) {
            if(sumOfCount.get(key) == max) {
                values.add(key);
            }
        }
        int[] result = new int[values.size()];
        for(int i = 0; i < values.size(); i++) {
           result[i] = values.get(i);
        }
        return result;

    }

    private int max = Integer.MIN_VALUE;
    private int dfs(TreeNode root, HashMap<Integer, Integer> sumOfCount) {
        if (root == null)
            return 0;
        int sumOfL = dfs(root.left, sumOfCount);
        int sumOfR = dfs(root.right, sumOfCount);
        int sum = sumOfL + sumOfR + root.val;
        Integer temp = sumOfCount.get(sum);
        if(temp == null) {
            temp = 0;
        }
        temp ++;
        if(max < temp) {
            max = temp;
        }
        sumOfCount.put(sum,temp);
        return sum;
    }
}
