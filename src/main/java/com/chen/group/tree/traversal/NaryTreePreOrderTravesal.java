package com.chen.group.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.chen.model.Node;

public class NaryTreePreOrderTravesal {
    public List<Integer> preorder(Node root) {

        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<Node>();

        if (root == null) {
            return list;
        }
        stack.push(root);
        while (stack.size() > 0) {

            Node temp = stack.pop();
            list.add(temp.val);
            if (temp.children != null) {
                for (int i = temp.children.size() - 1; i >= 0;i--) {
                    stack.push(temp.children.get(i));
                }
            }

        }
        return list;
    }
}
