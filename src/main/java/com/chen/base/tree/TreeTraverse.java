package com.chen.base.tree;

import com.chen.model.TreeNode;

import java.util.LinkedList;

public class TreeTraverse {
    public static void preOrderTraverse(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        preOrderTraverse(treeNode.left);
        preOrderTraverse(treeNode.right);
    }

    public static void preOrderTraverse2(TreeNode treeNode) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (treeNode != null || !stack.isEmpty()) {
            if (treeNode != null) {
                System.out.println(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            } else {
                treeNode = stack.pop().right;
            }
        }
    }

    public static void inOrderTraverse(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrderTraverse(treeNode.left);
        System.out.println(treeNode.val);
        inOrderTraverse(treeNode.right);
    }

    public static void inOrderTraverse2(TreeNode treeNode) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (treeNode != null || !stack.isEmpty()) {
            if (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            } else {
                treeNode = stack.pop();
                System.out.println(treeNode.val);
                treeNode = treeNode.right;
            }
        }
    }


    public static void postOrderTraverse(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrderTraverse(treeNode.left);
        postOrderTraverse(treeNode.right);
        System.out.println(treeNode.val);
    }

    public static void postOrderTraverse2(TreeNode treeNode) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode lastVist = treeNode;
        while (treeNode != null || !stack.isEmpty()) {

            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            treeNode = stack.peek();
            if(treeNode.right == null || treeNode.right ==lastVist) {
                System.out.println(treeNode.val);
                stack.pop();
                lastVist = treeNode;
                treeNode = null;
            } else {
                treeNode = treeNode.right;
            }
        }
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
        postOrderTraverse(root);
        System.out.println("==================");
        postOrderTraverse2(root);
    }


}
