package com.chen.leetcode;

public class SubTreeII {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }

    public boolean equalsTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && equalsTree(s.left, t.left) && equalsTree(s.right, s.right);
    }

    public boolean traverse(TreeNode s, TreeNode t) {
        return s != null && (equalsTree(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        TreeNode nodeA1 = new TreeNode(1);
        TreeNode nodeA2 = new TreeNode(2);
        TreeNode nodeA3 = new TreeNode(3);
        TreeNode nodeA4 = new TreeNode(4);
        TreeNode nodeA5 = new TreeNode(5);
        TreeNode nodeA6 = new TreeNode(6);
        TreeNode nodeA7 = new TreeNode(7);
        nodeA1.left = nodeA2;
        nodeA1.right = nodeA3;
        nodeA2.left = nodeA4;
        nodeA2.right = nodeA5;
        nodeA3.left = nodeA6;
        nodeA3.right = nodeA7;

        SubTreeII subTreeII = new SubTreeII();
        boolean iSubtree = subTreeII.isSubtree(node1, nodeA1);
        System.out.println(iSubtree);
    }
}
