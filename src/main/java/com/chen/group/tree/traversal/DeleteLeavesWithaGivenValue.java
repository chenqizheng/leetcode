package com.chen.group.tree.traversal;

import com.chen.model.TreeNode;

/**
 * https://leetcode.com/problems/delete-leaves-with-a-given-value/
 */
public class DeleteLeavesWithaGivenValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left != null || root.right != null || root.val != target) {
            return root;
        } else {
            return null;
        }
    }
}
