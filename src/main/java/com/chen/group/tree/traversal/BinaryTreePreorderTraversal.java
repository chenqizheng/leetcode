package com.chen.group.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.chen.model.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode tree = stack.pop();
            result.add(tree.val);
            if (tree.right != null) {
                stack.push(tree.right);
            }
            if (tree.left != null) {
                stack.push(tree.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
