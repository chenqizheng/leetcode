package com.chen.group.tree.traversal;

import com.chen.model.TreeNode;

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.left != null || root.right != null || root.val ==1) {
            return root;
        }
        return null;
    }
}
