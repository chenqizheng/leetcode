package com.chen.leetcode;

public class SortLinkList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode sort1 = sortList(head);
        ListNode sort2 = sortList(slow);
        return mergeSort(sort1, sort2);
    }

    private ListNode mergeSort(ListNode sort1, ListNode sort2) {
        ListNode preHead = new ListNode(0);
        ListNode temp = preHead;
        while (sort1 != null && sort2 != null) {
            if (sort1.val < sort2.val) {
                temp.next = sort1;
                sort1 = sort1.next;
            } else {
                temp.next = sort2;
                sort2 = sort2.next;
            }
            temp = temp.next;
        }

        if (sort1 != null) {
            temp.next = sort1;
        }
        if (sort2 != null) {
            temp.next = sort2;
        }
        return preHead.next;
    }
}
