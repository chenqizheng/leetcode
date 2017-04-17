package com.chen.leetcode;

/**
 * 根据前序遍历、中序遍历重构二叉树
 * Created by Chen on 2017/4/17.
 */
@Deprecated
public class ReBuildBinaryTree {

    public TreeNode solution(int[] preOrder, int[] inOrder) {
        TreeNode root = new TreeNode(preOrder[0]);
        rebuildBinaryTree(root, preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
        return root;
    }

    //TODO 未完成
    public void rebuildBinaryTree(TreeNode treeNode, int[] preOrder, int preOrderStart, int preOrderEnd, int[] inOrder, int inOrderStart, int inOrderEnd) {
        if (inOrderStart == inOrderEnd || preOrderStart == preOrderEnd) {
            if (findIndex(inOrder, 0, inOrder.length - 1, treeNode.val) > inOrderEnd) {
                treeNode.left = new TreeNode(inOrder[inOrderEnd]);
            } else {
                treeNode.right = new TreeNode(inOrder[inOrderEnd]);
            }
            return;
        }
        int root = preOrder[preOrderStart];
        int leftLenght = findIndex(inOrder, inOrderStart, inOrderEnd, root) - inOrderStart;
        if (preOrderStart + 1 < preOrder.length) {
            TreeNode left = new TreeNode(preOrder[preOrderStart + 1]);
            treeNode.left = left;
            if (preOrderStart <= leftLenght - 1) {
                rebuildBinaryTree(left, preOrder, preOrderStart + 1, leftLenght + preOrderStart, inOrder, inOrderStart, inOrderStart + leftLenght - 1);
            }
        }

        if (preOrderStart + leftLenght + 1 < preOrder.length) {
            TreeNode right = new TreeNode(preOrder[preOrderStart + leftLenght + 1]);
            treeNode.right = right;
            if (preOrderStart + leftLenght + 1 <= preOrderEnd) {
                rebuildBinaryTree(right, preOrder, preOrderStart + leftLenght + 1, preOrderEnd, inOrder, leftLenght + 1, inOrderEnd);
            }
        }


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
