package com.chen.leetcode;

public class MinimumDepth {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else {
            int leftDepth = minDepth(root.left) + 1;
            int rightDepth = minDepth(root.right) + 1;
            if(root.left == null ) {
                return rightDepth;
            } else if(root.right == null) {
                return leftDepth;
            }
            if (leftDepth > rightDepth) {
                return rightDepth;
            } else {
                return leftDepth;
            }
        }

    }

    public static final void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        System.out.println(minDepth(treeNode1));

    }
}
