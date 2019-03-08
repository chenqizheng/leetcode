package com.chen.leetcode;

public class RemoveLinkedList {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode16 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode6;
        listNode6.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode16;

        new RemoveLinkedList().removeElements(listNode1, 6);
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode current = head;
        ListNode preCurrent = pre;
        while (current != null) {
            if (current.val == val) {
                //delete
                preCurrent.next = current.next;
            } else {
                preCurrent = current;
            }
            current = current.next;

        }
        return pre.next;
    }
}
