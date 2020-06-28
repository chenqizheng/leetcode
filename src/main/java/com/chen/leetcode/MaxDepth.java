package com.chen.leetcode;

import com.chen.model.TreeNode;

/**
 * Created by Chen on 2017/5/3.
 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(3);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode6;

        System.out.println(new MaxDepth().maxDepth(treeNode));
    }

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 1);
    }

    public int maxDepth(TreeNode node, int high) {
        if (node == null) {
            return high - 1;
        }
        if (node.left == null && node.right == null) {
            return high;
        }
        return Math.max(maxDepth(node.left, high + 1), maxDepth(node.right, high + 1));
    }
}
