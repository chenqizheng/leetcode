package com.chen.leetcode;

/**
 * Created by Chen on 2017/5/3.
 */
public class OddEvenLindedList {

    /**
     * 删除偶数,置于链尾
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode footer = head;
        int count = 1;
        while (footer.next != null) {
            footer = footer.next;
            count++;
        }
        ListNode temp = head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        for(int i = 1; i <= count;i++){
            if ((i & 1) == 0) {
                //偶数
                footer.next = temp;
                pre.next = temp.next;
                temp.next = null;
                footer = temp;
                temp = pre.next;
            } else {
                pre = pre.next;
                temp = temp.next;
            }
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
        new OddEvenLindedList().oddEvenList(listNode1);
    }
}
