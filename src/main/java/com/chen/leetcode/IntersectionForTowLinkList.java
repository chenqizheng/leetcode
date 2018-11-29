package com.chen.leetcode;

public class IntersectionForTowLinkList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenghtA = lenght(headA);
        int lenghtB = lenght(headB);
        while (lenghtA > lenghtB) {
            headA = headA.next;
            lenghtA--;
        }
        while (lenghtB > lenghtA) {
            headB = headB.next;
            lenghtB--;
        }

        while (headA != headB) {
            if (headA == null || headB == null) {
                return null;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }


    public int lenght(ListNode head) {
        int lenght = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            lenght++;
        }
        return lenght;
    }
}
