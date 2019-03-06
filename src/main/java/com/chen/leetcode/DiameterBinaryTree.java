package com.chen.leetcode;

public class DiameterBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        root.left = root2;
        root.right = root3;
        root2.left = root4;
        root2.right = root5;
        int result = new DiameterBinaryTree().diameterOfBinaryTree(root);
        System.out.println(result);


    }

    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        max = 1;
        depth(root);
        return max - 1;
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        max = Math.max(l + r + 1, max);
        return Math.max(l, r) + 1;
    }

}
