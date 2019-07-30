package com.chen.offer;

import com.chen.model.TreeNode;

/***
 * 重建二叉树
 *
 * 输入某二叉树的前序和中序遍历结果，输出头界面
 */
public class ReconstructTree {


    private TreeNode solution(int[] pre, int[] middle) {
        TreeNode treeNode = rebuildBinaryTree(pre, 0, pre.length - 1, middle, 0, middle.length - 1);
        return treeNode;
    }

    private TreeNode rebuildBinaryTree(int[] pre, int preStart, int preEnd, int[] middle, int middleStart, int middleEnd) {
        TreeNode treeNode = new TreeNode(pre[preStart]);
        int index = findIndex(middle, middleStart, middleEnd, pre[preStart]);
        int leftLength = index - middleStart;
        if (leftLength > 0) {
            treeNode.left = rebuildBinaryTree(pre, preStart + 1, preStart + leftLength, middle, middleStart, middleStart + leftLength);
        }
        if (index + 1 < middleEnd) {
            treeNode.right = rebuildBinaryTree(pre, preStart + leftLength + 1, preEnd, middle, index + 1, middleEnd);
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
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] middle = new int[]{4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode treeNode = new ReconstructTree().solution(pre, middle);
        System.out.println(treeNode.val);
    }
}
