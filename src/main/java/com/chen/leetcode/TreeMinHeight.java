package com.chen.leetcode;

import com.chen.model.TreeNode;

import java.util.ArrayList;

public class TreeMinHeight {


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = minDepth(root.left) + 1;
        int rigthDepth = minDepth(root.right) + 1;
        if (root.left == null) {
            return rigthDepth;
        } else if (root.right == null) {
            return leftDepth;
        }
        if (leftDepth > rigthDepth) {
            return rigthDepth;
        } else {
            return leftDepth;
        }
    }


    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int k = queue.size();
            for (int i = 0; i < k; i++) {
                TreeNode treeNode = queue.remove(0);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                if (treeNode.left == null && treeNode.right == null) {
                    return depth;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
