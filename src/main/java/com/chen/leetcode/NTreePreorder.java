package com.chen.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NTreePreorder {
    public List<Integer> preorder(NTreePostorder.Node root) {
        List<Integer> list = new ArrayList<Integer>();
        preorder(root, list);
        return list;
    }

    private void preorder(NTreePostorder.Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        for (NTreePostorder.Node temp : root.children) {
            preorder(temp, list);
        }
    }
}
