package com.chen.leetcode;

import com.chen.model.TreeNode;

public class SortListToBST {

    public static void main(String[] args) {
        ListNode nodeS10 = new ListNode(-10);
        ListNode nodeS3 = new ListNode(-3);
        ListNode zero = new ListNode(0);
        ListNode node5 = new ListNode(5);
        ListNode node9 = new ListNode(9);
        nodeS10.next = nodeS3;
        nodeS3.next = zero;
        zero.next = node5;
        node5.next = node9;
        TreeNode treeNode = new SortListToBST().sortedListToBST(nodeS10);
        System.out.println(treeNode.toString());
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode preSlow = head;
        while (fast != null && fast.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        preSlow.next = null;
        TreeNode treeNode = new TreeNode(slow.val);
        treeNode.left = sortedListToBST(head);
        treeNode.right = sortedListToBST(slow.next);
        return treeNode;

    }
}
