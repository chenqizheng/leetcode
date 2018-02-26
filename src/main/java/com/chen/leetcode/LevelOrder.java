package com.chen.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        handle(lists, root, 0);
        return lists;
    }

    private void handle(List<List<Integer>> lists, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (lists.size() <= level) {
            lists.add(new ArrayList<Integer>());
        }
        List<Integer> list = lists.get(level);
        list.add(root.val);
        handle(lists, root.left, level + 1);
        handle(lists, root.right, level + 1);
    }
}
