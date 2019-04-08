package com.chen.nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreePrinter {
    public static void printTree(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        TreeNode last = root;
        TreeNode nLast = root;
        list.add(root);
        while (list.size() > 0) {
            TreeNode temp = list.remove(0);
            System.out.print(temp.val + " ");
            if (temp.left != null) {
                list.add(temp.left);
                nLast = temp.left;
            }
            if (temp.right != null) {
                list.add(temp.right);
                nLast = temp.right;
            }
            if (last.right == nLast) {
                System.out.println();
                last = nLast;
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
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        List<Integer> list = mediumPrintTree(treeNode1);
        for (int i : list
                ) {

            System.out.print(i + "   ");
        }
    }

    public static final void prePrintTree(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();

        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                list.add(treeNode.val);
                stack.add(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
    }

    public static final List<Integer> mediumPrintTree(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        while (!stack.isEmpty() || treeNode != null) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                list.add(treeNode.val);
                treeNode = treeNode.right;
            }
        }
        return list;
    }

    public static final void postfixPrintTree(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        while (!stack.isEmpty() || treeNode != null) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            TreeNode pre = null;
            boolean tag = true;
            if (!stack.isEmpty() && tag) {
                treeNode = stack.peek();
                if (treeNode.right == pre) {
                    treeNode = stack.pop();
                    list.add(treeNode.val);
                    if (stack.isEmpty()) {
                        return;
                    } else {
                        pre = treeNode;
                    }
                } else {
                    treeNode = treeNode.right;
                    tag = false;
                }
            }
        }
    }
}
