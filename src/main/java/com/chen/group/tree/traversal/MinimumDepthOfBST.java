package com.chen.group.tree.traversal;

import com.chen.model.TreeNode;

public class MinimumDepthOfBST {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int l = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
        int r = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;

        return Math.min(l, r) + 1;
    }
}
