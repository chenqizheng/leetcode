package com.chen.leetcode;

import java.util.Stack;

public class ReOrderLinkList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        pre = pre.next;
        pre.next =null;

        Stack<ListNode> stack = new Stack<ListNode>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        ListNode temp = head;
        while (!stack.empty() && temp != null) {
            ListNode tempNext = temp.next;
            ListNode listNode1 = stack.pop();
            temp.next = listNode1;
            listNode1.next = tempNext;
            temp = tempNext;
        }
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        new ReOrderLinkList().reorderList(l1);
    }
}
