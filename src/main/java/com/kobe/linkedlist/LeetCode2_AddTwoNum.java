package com.kobe.linkedlist;

import static com.kobe.linkedlist.LeetCode206_ReverseList.reverseList;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表
 *
 */
public class LeetCode2_AddTwoNum {
    public static void main(String[] args) {
        int[] arr1 = {2,4,3};
        int[] arr2 = {8,5,6,4};
        ListUtil.printList(addTwoNumbers(ListUtil.buildList(arr1),
                ListUtil.buildList(arr2)));
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //243 -- 342
        //1564 -- 465
        ListNode t1 = reverseList(l1);
        ListNode t2 = reverseList(l2);
        ListNode head = null;
        int i = 0;
        while (t1 != null || t2 != null){
            int v1 = t1 == null? 0: t1.val;
            int v2 = t2 == null? 0: t2.val;
            int v = v1 + v2 +i;
            i = 0;
            ListNode tmp = new ListNode();
            if (v>9){
                v %= 10;
                i = 1;
            }
            tmp.val = v;
            tmp.next = head;
            head = tmp;

            if (t1 != null){
                t1 = t1.next;
            }
            if (t2 != null){
                t2 = t2.next;
            }
        }

        return reverseList(head);
    }

}


