package com.kobe.linkedlist;

public class LeetCode206_ReverseList {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        ListNode head = ListUtil.buildList(arr);
        ListUtil.printList(head);
        //ListUtil.printList(reverseList(head));
        ListUtil.printList(reverseListRecursively(head));
    }
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null, curr = head, tmp = null;
        while (curr != null){
            tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }

        return pre;
    }

    private static ListNode reverseListRecursively(ListNode head) {
        if (head.next == null || head == null){
            return head;
        }

        ListNode p = reverseListRecursively(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }
}
