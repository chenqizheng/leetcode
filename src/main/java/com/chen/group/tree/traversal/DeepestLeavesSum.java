package com.chen.group.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.chen.model.Node;
import com.chen.model.TreeNode;

public class DeepestLeavesSum {

    private int sum;
    private int maxDepth;

    public int deepestLeavesSum(TreeNode root) {
        sum = 0;
        maxDepth = 0;
        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if(depth > maxDepth) {
            maxDepth = depth;
            sum = 0;
        }
        if(depth == maxDepth) {
            sum += node.val;
        }
        dfs(node.left, depth +1 );
        dfs(node.right, depth +1 );
    }
}
