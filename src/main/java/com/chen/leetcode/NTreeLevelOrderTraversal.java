package com.chen.leetcode;

import com.chen.model.Node;

import java.util.*;

/***
 *  https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */
public class NTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Node> list = new LinkedList<>();
        if (root == null) {
            return result;
        }
        list.add(root);
        while (list.size() > 0) {
            int length = list.size();
            LinkedList lineList = new LinkedList();
            for (int i = 0; i < length; i++) {
                Node temp = list.poll();
                if (temp != null) {
                    lineList.offer(temp.val);
                    for (Node node : temp.children) {
                        list.offer(node);
                    }
                }

            }
            result.add(lineList);
        }

        return result;
    }

}
