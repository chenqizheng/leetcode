package com.chen.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NTreePostorder {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        postOrder(root, list);
        return list;
    }

    public void postOrder(Node node, List<Integer> list) {
        if (node != null) {
            for (Node temp : node.children) {
                postOrder(temp, list);
            }
            list.add(node.val);
        }
    }

}
