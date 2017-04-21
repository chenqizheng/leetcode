package com.chen.leetcode;

/**
 * 判断是否是子树
 * Created by Chen on 2017/4/19.
 */
public class SubTree {

    /**
     * 步骤:
     * 1、找到与根节点相等的节点
     * 2、判断下面节点是否一样
     *
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubTree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        boolean result = false;
        if (root.val == subRoot.val) {
            result = isEqual(root, subRoot);
        } else {
            result |= isSubTree(root.left, subRoot);
            result |= isSubTree(root.right, subRoot);
        }
        return result;
    }

    private boolean isEqual(TreeNode root, TreeNode subRoot) {
        boolean result = false;
        if (root != null && subRoot != null) {
            result = root.val == subRoot.val;
        }
        if (subRoot.left != null) {
            result &= isEqual(root.left, subRoot.left);
        }
        if (subRoot.right != null) {
            result &= isEqual(root.right, subRoot.right);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode_3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        root.left = treeNode3;
        root.right = treeNode2;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode_3;
        treeNode2.right = treeNode9;

        System.out.println(new SubTree().isSubTree(root, treeNode9));

    }
}
