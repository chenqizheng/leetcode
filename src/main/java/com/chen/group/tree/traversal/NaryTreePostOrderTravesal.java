package com.chen.group.tree.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.chen.model.Node;

public class NaryTreePostOrderTravesal {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            for (Node temp : node.children) {
                stack.push(temp);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
