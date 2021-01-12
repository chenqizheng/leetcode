package com.chen.group.tree.traversal;

import java.util.ArrayList;
import java.util.List;

import com.chen.model.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        if(root != null) binaryTreePaths(root, paths,"");
        return paths;
    }

    private void binaryTreePaths(TreeNode root, List<String> paths, String current) {
        if(root.left == null && root.right == null) {
            paths.add(current + root.val);
        }
        if(root.left != null) {
            binaryTreePaths(root.left, paths, current + root.val + "->");
        }
        if(root.right != null) {
            binaryTreePaths(root.right, paths, current + root.val + "->");
        }
    }
}
