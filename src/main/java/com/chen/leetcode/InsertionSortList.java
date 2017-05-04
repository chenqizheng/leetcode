package com.chen.leetcode;

/**
 * href: https://leetcode.com/problems/insertion-sort-list/#/description
 * Created by Chen on 2017/5/4.
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode p;
        ListNode q = head.next;
        ListNode preQ = head;
        ListNode preP;
        int count = 0;
        while (q != null) {
            preP = null;
            p = head;
            count = count + 1;
            //需要个pre q 指针
            for (int i = 0; i < count; i++) {
                if (p.val < q.val && p.next != null && p.next.val > q.val) {
                    ListNode temp = q.next;
                    preQ.next = temp;
                    q.next = p;
                    if (preP == null) {
                        head = q;
                    } else {
                        preP.next = q;
                    }
                } else {
                    preP = p;
                    p = p.next;
                }
            }
            preQ = q;
            q = q.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        new InsertionSortList().insertionSortList(listNode1);
    }
}
