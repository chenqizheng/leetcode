package com.chen.leetcode;

import java.util.List;
import java.util.Stack;

public class ReverseLinkedList {


    // 内存限制
//    public ListNode reverseList(ListNode head) {
//        Stack<ListNode> stack = new Stack();
//        while (head != null) {
//            stack.push(head);
//            head = head.next;
//        }
//
//        ListNode reverseHead = stack.peek();
//        ListNode pre = reverseHead;
//        while (!stack.empty()) {
//            ListNode temp = stack.pop();
//            pre.next = temp;
//            pre = temp;
//        }
//        return reverseHead;
//    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        new ReverseLinkedList().reverseList(l1);
    }

    private ListNode reverseList(ListNode l1) {
        ListNode pre = null;
        ListNode next = l1;
        while(next != null){
            ListNode temp = next.next;
            next.next = pre;
            pre = next;
            next =temp;
        }
        return pre;
    }
}
