package com.chen.leetcode;

/***
 * leetcode:https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesSortedList {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        new RemoveDuplicatesSortedList().deleteDuplicates(listNode1);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode current = head.next;
        while (current != null) {
            if (pre.val == current.val) {
                pre.next = current.next;
                current = pre.next;
            } else {
                pre = current;
                current = current.next;
            }

        }
        return head;
    }
}
