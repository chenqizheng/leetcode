package com.chen.leetcode;

import com.chen.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Chen on 2017/4/25.
 */
public class InOrderTree {
    public List<Integer> inOrderTree(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                list.add(current.val);
                current = current.right;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);

        TreeNode treeNode9 = new TreeNode(9);

        root.left = treeNode3;
        root.right = treeNode2;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode4;
        treeNode2.right = treeNode9;
        new InOrderTree().inOrderTree(root);
    }
}
