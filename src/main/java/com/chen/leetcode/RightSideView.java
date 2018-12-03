package com.chen.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
//    public List<Integer> rightSideView(TreeNode root) {
//        List<List<Integer>> lists = new ArrayList();
//        floorsTree(root, lists, 0);
//        List<Integer> rightSideView = new ArrayList<Integer>();
//        for (List<Integer> temp : lists) {
//            rightSideView.add(temp.get(temp.size() - 1));
//        }
//        return rightSideView;
//    }
//
//    private void floorsTree(TreeNode root, List<List<Integer>> lists, int i) {
//        if (root == null) return;
//        if (i > lists.size() - 1) {
//            lists.add(new ArrayList<Integer>());
//        }
//        List<Integer> list = lists.get(i);
//        list.add(root.val);
//        floorsTree(root.left, lists, i + 1);
//        floorsTree(root.right, lists, i + 1);
//    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideView = new ArrayList<Integer>();
        rightSideView(root, rightSideView, 0);
        return rightSideView;
    }

    private void rightSideView(TreeNode root, List<Integer> rightSideView, int i) {
        if (root == null) return;
        if (i == rightSideView.size()) {
            rightSideView.add(root.val);
        }
        rightSideView(root.right, rightSideView, i + 1);
        rightSideView(root.left, rightSideView, i + 1);
    }
}
