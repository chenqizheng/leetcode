package com.chen.group.tree.traversal;

import com.chen.model.TreeNode;

public class LongestUnivaluePath {
    private int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        dfs(root, Integer.MIN_VALUE);
        return ans;
    }

    private int dfs(TreeNode root, int parent) {
        if (root == null) {
            return -1;
        }
        int l = dfs(root.left, root.val) + 1;
        int r = dfs(root.right, root.val) + 1;
        ans = Math.max(ans, l + r);
        return parent == root.val ? Math.max(l, r) : -1;

    }
}
