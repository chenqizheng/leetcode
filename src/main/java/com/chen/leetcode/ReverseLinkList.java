package com.chen.leetcode;

/**
 * Created by Chen on 2017/3/30.
 * herf: https://leetcode.com/problems/reverse-linked-list-ii/#/description
 * 链表操作需要pre的可以用一个linknode指向head来解决
 */
public class ReverseLinkList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode start = head, pre = preHead;
        for (int i = 0; i < m - 1; i++) {
            start = start.next;
            pre = pre.next;
        }

        for (int i = m; i < n; i++) {
            ListNode temp = start.next;
            start.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        printlnLinkNode(preHead);
        return preHead.next;
    }

    public void printlnLinkNode(ListNode node){
        while (node.next!=null){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
        listNode3.next = listNode5;
        new ReverseLinkList().reverseBetween(listNode3, 1, 2);
    }
}
