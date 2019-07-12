package com.chen.leetcode;

import com.chen.model.TreeNode;

/**
 * 根据前序遍历、中序遍历重构二叉树
 * Created by Chen on 2017/4/17.
 */
public class ReBuildBinaryTree {

    public TreeNode solution(int[] preOrder, int[] inOrder) {
        return rebuildBinaryTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    public TreeNode rebuildBinaryTree(int[] preOrder, int preOrderStart, int preOrderEnd, int[] inOrder, int inOrderStart, int inOrderEnd) {
        TreeNode treeNode = new TreeNode(preOrder[preOrderStart]);
        int index = findIndex(inOrder, inOrderStart, inOrderEnd, preOrder[preOrderStart]);
        int leftlength = index - inOrderStart;
        if (leftlength > 0) {
            //构建 左子树
            treeNode.left = rebuildBinaryTree(preOrder, preOrderStart + 1, preOrderStart + leftlength, inOrder, inOrderStart, inOrderStart + leftlength);
        }
        if (index + 1 < inOrderEnd) {
            //构建 右子树
            treeNode.right = rebuildBinaryTree(preOrder, preOrderStart + leftlength + 1, preOrderEnd, inOrder, index + 1, inOrderEnd);
        }
        return treeNode;
    }

    public int findIndex(int[] array, int start, int end, int target) {
        int index = -1;
        for (int i = start; i <= end; i++) {
            if (array[i] == target) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new RuntimeException("no found");
        }
        return index;
    }

    public static void main(String[] args) {
        ReBuildBinaryTree reBuildBinaryTree = new ReBuildBinaryTree();
        int[] preOrder = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = reBuildBinaryTree.solution(preOrder, inOrder);
        System.out.println("treenode = " + treeNode.val);
    }
}
