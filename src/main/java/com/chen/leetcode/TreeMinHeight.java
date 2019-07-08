package com.chen.leetcode;

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

    public static void main(String[] args) {

    }
}
