package com.chen.leetcode;

import java.util.Stack;

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode pre = null;
        int sub = 0;
        while (!s1.empty() || !s2.empty()) {
            int key1 = s1.empty() ? 0 : s1.pop();
            int key2 = s2.empty() ? 0 : s2.pop();
            int sum = key1 + key2 + sub;

            ListNode temp = pre;
            pre = new ListNode(sum % 10);
            pre.next = temp;
            if (sum >= 10) {
                sub = 1;
            } else {
                sub =0;
            }
        }
        if (sub == 1) {
            ListNode head = new ListNode(1);
            head.next = pre;
            pre = head;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(4);
        l5.next = l6;
        l6.next = l7;
        new AddTwoNumber().addTwoNumbers(l1, l5);
    }
}
