package com.chen.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/***
 * leetcode:https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<TreeNode> list = new ArrayList<>();

        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                list.add(treeNode);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }

        }
        for (TreeNode temp : list) {
            temp.left = null;
            int nextIndex = list.indexOf(temp) + 1;
            if (nextIndex < list.size()) {
                temp.right = list.get(nextIndex);
            } else {
                temp.right = null;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode5;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode5.right = treeNode6;
        new FlattenBinaryTreeToLinkedList().flatten(treeNode1);
        System.out.print(treeNode1);
    }


}
