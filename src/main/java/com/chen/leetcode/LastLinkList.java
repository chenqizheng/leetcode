package com.chen.leetcode;

/**
 * 链表倒数第k个节点
 * Created by Chen on 2017/4/19.
 */
public class LastLinkList {
    public ListNode solution(ListNode head, int k) {
        ListNode kNode = head;
        while (k > 0) {
            kNode = kNode.next;
            k--;
        }
        while (kNode != null) {
            kNode = kNode.next;
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode9 = new ListNode(9);
        ListNode listNode10 = new ListNode(10);
        ListNode listNode11 = new ListNode(11);
        ListNode listNode12 = new ListNode(12);
        ListNode listNode13 = new ListNode(13);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = listNode10;
        listNode10.next = listNode11;
        listNode11.next = listNode12;
        listNode12.next = listNode13;

        ListNode temp = new LastLinkList().solution(listNode1, 3);

        System.out.println("last = " + temp.val);
    }
}
