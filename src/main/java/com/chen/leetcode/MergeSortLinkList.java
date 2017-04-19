package com.chen.leetcode;

/**
 * Created by Chen on 2017/4/19.
 */
public class MergeSortLinkList {
    public ListNode solution(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        } else if (listNode2 == null) {
            return listNode1;
        }
        ListNode mergeListNode = null;
        if (listNode1.val > listNode2.val) {
            mergeListNode = listNode2;
            mergeListNode.next = solution(listNode1, listNode2.next);
        } else {
            mergeListNode = listNode1;
            mergeListNode.next = solution(listNode1.next, listNode2);
        }
        return mergeListNode;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(14);
        ListNode listNode7 = new ListNode(1);
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
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = listNode10;
        listNode10.next = listNode11;
        listNode11.next = listNode12;
        listNode12.next = listNode13;

        ListNode listNode = new MergeSortLinkList().solution(listNode1, listNode7);
        while (listNode != null) {
            System.out.print(" , " + listNode.val);
            listNode = listNode.next;
        }
        ;
    }
}
