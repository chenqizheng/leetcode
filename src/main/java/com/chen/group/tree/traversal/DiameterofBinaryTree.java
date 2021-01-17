package com.chen.group.tree.traversal;

import com.chen.model.TreeNode;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class DiameterofBinaryTree {
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int l = dfs(root.left) + 1;
        int r = dfs(root.right) + 1;
        ans = Math.max(l + r, ans);
        return Math.max(l, r);
    }
}
