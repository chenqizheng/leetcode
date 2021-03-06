package com.chen.leetcode;

import com.chen.model.TreeNode;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t2 == null && t1 != null) {
            return t1;
        }
        if (t1 == null && t2 != null) {
            return t2;
        }
        if (t1 != null && t2 != null) {
            TreeNode treeNode = new TreeNode(t1.val + t2.val);
            treeNode.left = mergeTrees(t1.left, t2.left);
            treeNode.right = mergeTrees(t1.right, t2.right);
            return treeNode;
        }
        return null;
    }
}
