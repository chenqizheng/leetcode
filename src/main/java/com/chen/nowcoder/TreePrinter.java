package com.chen.nowcoder;

import java.util.ArrayList;

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

        printTree(treeNode1);
    }
}
