package com.chen.group.tree.traversal;

import com.chen.model.TreeNode;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return result[0] > result[1] ? result[0] : result[1];
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] { 0, 0 };
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int select =  l[1] + r[1] + root.val;
        int noSelect = Math.max(l[0] ,l[1]) + Math.max(r[0] ,r[1]);
        return new int[] {select, noSelect};
    }
}
