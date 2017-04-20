package com.chen.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * href:https://leetcode.com/problems/path-sum-ii/#/description
 * Created by Chen on 2017/4/20.
 */
public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        computeTree(lists, list, root, sum);
        return lists;
    }

    public void computeTree(ArrayList<List<Integer>> lists, ArrayList<Integer> list, TreeNode treeNode, int sum) {
        if (treeNode == null) {
            return;
        }
        list.add(treeNode.val);
        int result = sum - treeNode.val;
        //和为0并且是叶子节点
        if (result == 0 && treeNode.left == null && treeNode.right == null) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (Integer node : list
                    ) {
                temp.add(node);
            }
            lists.add(temp);

        }
        if (treeNode.left != null) {
            computeTree(lists, list, treeNode.left, result);
        }
        if (treeNode.right != null) {
            computeTree(lists, list, treeNode.right, result);
        }
        if (list.size() > 0)
            list.remove(list.size() - 1);
    }


    public static void main(String[] args) {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode13 = new TreeNode(13);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode4_1 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode5_1 = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);

        treeNode5.left = treeNode4;
        treeNode5.right = treeNode8;

        treeNode4.left = treeNode11;
        treeNode11.left = treeNode7;
        treeNode11.right = treeNode2;
        treeNode8.left = treeNode13;
        treeNode8.right = treeNode4_1;
        treeNode4_1.left = treeNode5_1;
        treeNode4_1.right = treeNode1;

        List<List<Integer>> is = new PathSum().pathSum(treeNode5, 22);
        System.out.println("test");

    }
}
