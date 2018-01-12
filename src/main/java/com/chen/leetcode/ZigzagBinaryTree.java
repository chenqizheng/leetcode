package com.chen.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZigzagBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static final void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;

        System.out.println(zigzagLevelOrder(treeNode3));

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) {
            return lists;
        }
        getZigzagLevelOrder(root, lists, 0);
        for (int index = 0; index < lists.size(); index++) {
            if (index % 2 == 1) {
                Collections.reverse(lists.get(index));
            }
        }
        return lists;
    }

    public static void getZigzagLevelOrder(TreeNode root, List<List<Integer>> lists, int row) {
        List<Integer> list;
        if (lists.size() > row) {
            list = lists.get(row);
        } else {
            list = new ArrayList<Integer>();
            lists.add(list);
        }
        list.add(root.val);
        if (root.left != null) {
            getZigzagLevelOrder(root.left, lists, row + 1);
        }
        if (root.right != null) {
            getZigzagLevelOrder(root.right, lists, row + 1);
        }
    }

}
