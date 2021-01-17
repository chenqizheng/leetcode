package com.chen.group.tree.traversal;

import com.chen.model.TreeNode;

public class BinaryTreeMaximumPathSum {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }

    public int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sumL = Math.max(0, maxGain(root.left));
        int sumR = Math.max(0, maxGain(root.right));
        int temp = sumL + sumR + root.val;
        if (temp > max) {
            max = temp;
        }
        return root.val + Math.max(sumL, sumR);
    }
}
