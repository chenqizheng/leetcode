package com.chen.leetcode;

import com.chen.model.TreeNode;

/**
 * leetcode :https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/submissions/
 */
public class ConstructBinaryTreefromInorderPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        TreeNode treeNode = buildTree(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
        return treeNode;
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postEnd) {
        if (postEnd < 0) {
            return null;
        }
        if (inStart > inEnd) {
            return null;
        }
        if (inStart == inEnd) {
            return new TreeNode(inorder[inStart]);
        }
        TreeNode treeNode = new TreeNode(postorder[postEnd]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postEnd]) {
                index = i;
                break;
            }
        }
        treeNode.left = buildTree(inorder, inStart, index - 1, postorder, postEnd - (inEnd - index + 1));
        treeNode.right = buildTree(inorder, index + 1, inEnd, postorder, postEnd - 1);
        return treeNode;
    }

    public static void main(String[] args) {
        new ConstructBinaryTreefromInorderPostorderTraversal().buildTree(new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 3});
    }
}
