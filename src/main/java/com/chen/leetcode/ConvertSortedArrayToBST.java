package com.chen.leetcode;

import com.chen.model.TreeNode;

public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = handle(nums, 0, nums.length - 1);
        return root;
    }

    // -10 -3 0 9;

    public TreeNode handle(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int mid = (start + end) / 2;
        TreeNode midTreeNode = new TreeNode(nums[mid]);
        midTreeNode.left = handle(nums, start, mid - 1);
        midTreeNode.right = handle(nums, mid + 1, end);
        return midTreeNode;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode treeNode = new ConvertSortedArrayToBST().sortedArrayToBST(nums);
        System.out.println("log");
    }
}
