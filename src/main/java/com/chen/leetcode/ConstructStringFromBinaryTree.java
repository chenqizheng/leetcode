package com.chen.leetcode;


import com.chen.model.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null) {
            return "" + t.val;
        }
        if (t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }
        return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }

    public String tree2str2(TreeNode t) {
        if (t == null) {
            return "";
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(t);
        Set<TreeNode> set = new HashSet<TreeNode>();
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            t = stack.peek();
            if (set.contains(t)) {
                stack.pop();
                sb.append(")");
            } else {
                set.add(t);
                sb.append("(");
                sb.append(t.val);
                if (t.left == null && t.right != null) {
                    sb.append("()");
                }
                if (t.right != null) {
                    stack.push(t.right);
                }
                if (t.left != null) {
                    stack.push(t.left);
                }
            }
        }
        return sb.toString().substring(1, sb.length() - 1);

    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.right = treeNode3;

        System.out.println(new ConstructStringFromBinaryTree().tree2str(treeNode));
    }
}
