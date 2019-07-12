package com.chen.leetcode;

import com.chen.model.TreeNode;

public class PathSumIII {


    public static void main(String[] args) {
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNodeS3 = new TreeNode(-3);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNodeO3 = new TreeNode(3);
        TreeNode treeNodeS2 = new TreeNode(-2);
        TreeNode treeNode1 = new TreeNode(1);

        treeNode10.left = treeNode5;
        treeNode10.right = treeNodeS3;
        treeNode5.left = treeNode3;
        treeNode5.right = treeNode2;
        treeNode3.left = treeNodeO3;
        treeNode3.right = treeNodeS2;
        treeNode5.right = treeNode2;
        treeNode2.right = treeNode1;
        treeNode10.right = treeNodeS3;
        treeNodeS3.right = treeNode11;
        System.out.println(new PathSumIII().pathSum(treeNode10, 8));
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return pathSum(root.left, sum) + pathSum(root.right, sum) + findPath(root, sum);
    }

    public int findPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        if (sum == root.val) {
            return 1;
        }
        ret += findPath(root.left, sum - root.val);
        ret += findPath(root.right, sum - root.val);
        return ret;
    }
}
