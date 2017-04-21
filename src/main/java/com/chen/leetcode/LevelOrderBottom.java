package com.chen.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * href: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/#/description
 * Created by Chen on 2017/4/21.
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        traverseTree(lists, root, 0);
        Collections.reverse(lists);
        return lists;
    }

    public void traverseTree(List<List<Integer>> lists, TreeNode root, int h) {
        if (root == null) {
            return;
        }
        if (h >= lists.size()) {
            List<Integer> list = new ArrayList<Integer>();
            lists.add(list);
        }
        List<Integer> temp = lists.get(h);
        temp.add(root.val);
        if (root.left != null) {
            traverseTree(lists, root.left, h + 1);
        }
        if (root.right != null) {
            traverseTree(lists, root.right, h + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode((7));
        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;

        List<List<Integer>> lists = new LevelOrderBottom().levelOrderBottom(treeNode3);
        for (List<Integer> list : lists
                ) {
            for (Integer i : list
                    ) {
                System.out.print(i + ",");
            }
            System.out.println("");
        }
    }
}
