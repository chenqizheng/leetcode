package com.chen.group.tree.traversal;

import com.chen.model.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isEqual(root,root);
    }

    public boolean isEqual(TreeNode root1,TreeNode root2) {
        if(root1 == null && root2 == null ) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val && isEqual(root1.left, root2.right) && isEqual(root1.right, root2.left);
    }
}
