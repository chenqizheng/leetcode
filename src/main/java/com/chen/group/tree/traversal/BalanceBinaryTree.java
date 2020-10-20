package com.chen.group.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.chen.model.TreeNode;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class BalanceBinaryTree {
    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        this.isBalanced = true;
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if (root == null)
            return -1;
        if(!isBalanced) {
            return -1;
        }
        int l = height(root.left);
        int r = height(root.right);
        if(Math.abs(l-r) > 1 ) {
            isBalanced = false;
            return -1;
        }
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {

    }
}
