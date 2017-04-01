package com.chen.leetcode;


/**
 * Created by Chen on 2017/4/1.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSymmetricEqule(root.left, root.right);
    }

    public boolean isSymmetricEqule(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null && treeNode2 == null) {
            return true;
        }
        if (treeNode1 == null || treeNode2 == null) {
            return false;
        }
        if (treeNode1.val == treeNode2.val) {
            return isSymmetricEqule(treeNode1.left, treeNode2.right) && isSymmetricEqule(treeNode1.right, treeNode2.left);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode treeNode4 = new TreeNode(4);
//        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(3);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.right = treeNode3;
//        treeNode1.right = treeNode4;
//        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        System.out.println(new SymmetricTree().isSymmetric(treeNode));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}