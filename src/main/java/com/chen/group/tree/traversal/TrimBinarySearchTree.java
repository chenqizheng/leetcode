package com.chen.group.tree.traversal;

import com.chen.model.TreeNode;

/**
 * https://zxi.mytechroad.com/blog/leetcode/leetcode-669-trim-a-binary-search-tree/
 */
public class TrimBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if(root.val < low) {
            return trimBST(root.right, low,high);
        }
        if(root.val > high) {
            return trimBST(root.left, low,high);
        }
        root.left = trimBST(root.left, low,high);
        root.right = trimBST(root.right, low,high);
        return root;
    }
}
