package com.chen.group.tree.traversal;

import java.util.ArrayList;
import java.util.List;

import com.chen.model.TreeNode;

/**
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        pathSum(root,sum,result,current);
        return result;
    }

    public void pathSum(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> current) {
        if (root == null) {
            return;
        }
        current.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                ans.add(new ArrayList<Integer>(current));
            }
            return;
        }
      
        if(root.left != null) {
            pathSum(root.left, sum - root.val, ans, current);
            current.remove(current.size() - 1);
        }
        if(root.right != null) { 
            pathSum(root.right, sum - root.val, ans, current);
            current.remove(current.size() - 1);
        }
    }
}
