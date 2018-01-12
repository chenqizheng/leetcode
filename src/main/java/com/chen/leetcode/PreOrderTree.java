package com.chen.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * herf : https://leetcode.com/problems/binary-tree-preorder-traversal/#/description
 * Created by Chen on 2017/4/21.
 */
public class PreOrderTree {

    private List<Integer> mPreOrderList = new ArrayList<Integer>();

    /**
     * 递归写法
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        if (root != null) {
            mPreOrderList.add(root.val);
            preorderTraversalRecursive(root.left);
            preorderTraversalRecursive(root.right);
        }
        return mPreOrderList;
    }

    /**
     * 循环写法
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalRecursive1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                list.add(current.val);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;
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
        List<Integer> list = new PreOrderTree().preorderTraversalRecursive1(root);
        for (Integer integer : list) {
            System.out.print(integer);
        }
    }
}
