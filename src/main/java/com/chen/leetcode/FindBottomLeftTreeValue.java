package com.chen.leetcode;

/**
 * Created by Chen on 2017/4/1.
 * herf : https://leetcode.com/problems/find-bottom-left-tree-value/#/description
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        int[] res = new int[]{0, 0};
        findBottomLeftValueOnTree(root, 1, res);
        return res[0];
    }


    public void findBottomLeftValueOnTree(TreeNode treeNode, int h, int[] res) {
        if(treeNode == null) {
            return;
        }
        if (h > res[1]) {
            res[1] = h;
            res[0] = treeNode.val;
        }
        if (treeNode.left != null) findBottomLeftValueOnTree(treeNode.left, h + 1, res);
        if (treeNode.right != null) findBottomLeftValueOnTree(treeNode.right, h + 1, res);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(7);

//        treeNode.left = treeNode1;
//        treeNode.right = treeNode2;
//        treeNode1.left = treeNode3;
//        treeNode2.left = treeNode4;
//        treeNode2.right = treeNode5;
//        treeNode4.left = treeNode6;
        int sign = new FindBottomLeftTreeValue().findBottomLeftValue(treeNode);
        System.out.println("sign = " + sign);
    }
}
