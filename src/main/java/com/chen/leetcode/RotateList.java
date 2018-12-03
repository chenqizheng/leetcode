package com.chen.leetcode;

import java.util.Stack;

public class RotateList {
//    public ListNode rotateRight(ListNode head, int k) {
//        if (k == 0 || head == null || head.next == null) {
//            return head;
//        }
//        Stack<ListNode> stack = new Stack<ListNode>();
//        ListNode temp = head;
//        int count = 0;
//        while (temp != null) {
//            stack.push(temp);
//            temp = temp.next;
//            count++;
//        }
//        k = k % count;
//        while (k > 0) {
//            ListNode last = stack.pop();
//            ListNode preLast = stack.peek();
//            preLast.next = null;
//            last.next = head;
//            head = last;
//            k--;
//        }
//        return head;
//    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode last = head;
        int lenght = 0;
        while (temp != null) {
            lenght++;
            last = temp;
            temp = temp.next;
        }
        k = k % lenght;
        int count = lenght - k;
        temp = head;
        while (count > 1) {
            temp = temp.next;
            count--;
        }
        last.next = head;
        head = temp.next;
        temp.next = null;
        return head;
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

        new RotateList().rotateRight(l1, 2);
    }
}
