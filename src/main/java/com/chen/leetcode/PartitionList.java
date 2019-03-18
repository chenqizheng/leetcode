package com.chen.leetcode;

/***
 * leetcode :https://leetcode.com/problems/partition-list/
 */
public class PartitionList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        new PartitionList().partition(node1, 3);

    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode pre2 = new ListNode(0);

        ListNode current = head;
        ListNode preCurrent = pre;
        ListNode preCurrent2 = pre2;
        while (current != null) {
            if (current.val >= x) {
                ListNode temp = current;
                preCurrent.next = current.next;
                current = current.next;
                preCurrent2.next = temp;
                temp.next = null;
                preCurrent2 = preCurrent2.next;


            } else {
                preCurrent = current;
                current = current.next;
            }
        }
        preCurrent.next = pre2.next;
        return pre.next;
    }
}
