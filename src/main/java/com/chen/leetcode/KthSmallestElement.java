package com.chen.leetcode;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 */
public class KthSmallestElement {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mTreeNode;

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        getTreeNodeCount(list, root, k);
        return mTreeNode == null ? 0 : mTreeNode.val;
    }

    public void getTreeNodeCount(ArrayList<TreeNode> list, TreeNode root, int k) {
        if (root == null) {
            return;
        }

        getTreeNodeCount(list, root.left, k);
        list.add(root);
        if (list.size() == k) {
            mTreeNode = root;
        }
        getTreeNodeCount(list, root.right, k);
    }

    public static final void main(String[] args) {
        KthSmallestElement element = new KthSmallestElement();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode.right = treeNode2;
        System.out.print(element.kthSmallest(treeNode, 1));
    }
}
