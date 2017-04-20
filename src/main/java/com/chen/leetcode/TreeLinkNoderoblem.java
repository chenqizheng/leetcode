package com.chen.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * href: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/#/description
 * Created by Chen on 2017/4/20.
 */
public class TreeLinkNoderoblem {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        HashMap<Integer, ArrayList<TreeLinkNode>> hashMap = new HashMap<Integer, ArrayList<TreeLinkNode>>();
        connectTree(hashMap, root, 1);
        for (Integer key : hashMap.keySet()) {
            ArrayList<TreeLinkNode> arrayList = hashMap.get(key);
            for (int i = 1; i < arrayList.size(); i++) {
                arrayList.get(i - 1).next = arrayList.get(i);
            }
        }
    }

    public void connectTree(HashMap<Integer, ArrayList<TreeLinkNode>> hashMap, TreeLinkNode root, int height) {
        if (hashMap.containsKey(height)) {
            hashMap.get(height).add(root);
        } else {
            ArrayList<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
            list.add(root);
            hashMap.put(height, list);
        }
        if (root.left != null) {
            connectTree(hashMap, root.left, height + 1);
        }
        if (root.right != null) {
            connectTree(hashMap, root.right, height + 1);
        }
    }

    public static void main(String[] args) {
        TreeLinkNode treeLinkNode1 = new TreeLinkNode(1);
        TreeLinkNode treeLinkNode2 = new TreeLinkNode(2);
        TreeLinkNode treeLinkNode3 = new TreeLinkNode(3);
        TreeLinkNode treeLinkNode4 = new TreeLinkNode(4);
        TreeLinkNode treeLinkNode5 = new TreeLinkNode(5);
        TreeLinkNode treeLinkNode6 = new TreeLinkNode(6);
        TreeLinkNode treeLinkNode7 = new TreeLinkNode(7);
        treeLinkNode1.left = treeLinkNode2;
        treeLinkNode1.right = treeLinkNode3;
        treeLinkNode2.left = treeLinkNode4;
        treeLinkNode2.right = treeLinkNode5;
        treeLinkNode3.left = treeLinkNode6;
        treeLinkNode3.right = treeLinkNode7;
        new TreeLinkNoderoblem().connect(treeLinkNode1);
    }

    static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
