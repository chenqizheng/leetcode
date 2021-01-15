package com.chen.group.tree.traversal;

import com.chen.model.TreeNode;

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "X";
        }
        return "(" + serialize(root.left) + ")" + root.val + "(" + serialize(root.right) + ")";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] ptr = { 0 };
        return parse(data, ptr);
    }

    private TreeNode parse(String data, int[] ptr) {
        if (data.charAt(ptr[0]) == 'X') {
            ptr[0]++;
            return null;
        }
        TreeNode cur = new TreeNode(0);
        cur.left = parseSubTree(data, ptr);
        cur.val = parseInt(data, ptr);
        cur.right = parseSubTree(data, ptr);
        return cur;
    }

    private int parseInt(String data, int[] ptr) {
        int x = 0;
        int sign = 1;
        if(!Character.isDigit(data.charAt(ptr[0]))) {
            ptr[0]++;
            sign = -1;
        }

        while(Character.isDigit(data.charAt(ptr[0]))) {
            x = x * 10 + (data.charAt(ptr[0]) - '0');
            ptr[0]++;

        }
        return x * sign;
    }

    private TreeNode parseSubTree(String data, int[] ptr) {
        ptr[0]++;
        TreeNode cur = parse(data, ptr);
        ptr[0]++;
        return cur;
    }
}
