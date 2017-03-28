package com.chen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chen on 2017/3/28.
 */
public class LargestTreeRow {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        eachTree(root, list, 0);
        return list;
    }

    public void eachTree(TreeNode node, List<Integer> list, int h) {
        if (node == null)
            return;
        if (list.size() - 1 < h) {
            list.add(node.val);
        } else {
            Integer max = list.get(h);
            list.set(h, Math.max(max, node.val));
        }
        eachTree(node.left, list, h + 1);
        eachTree(node.right, list, h + 1);
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

        new LargestTreeRow().largestValues(root);


    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
