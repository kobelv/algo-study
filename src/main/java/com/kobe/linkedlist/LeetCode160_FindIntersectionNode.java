package com.kobe.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
public class LeetCode160_FindIntersectionNode {


    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //遍历一个链表，先存储起来值，再遍历另一个链表
        Set<ListNode> set = new HashSet<>();

        ListNode tmp = headA;
        while (tmp != null){
            set.add(tmp);
            tmp = tmp.next;
        }

        tmp = headB;
        while (tmp != null){
            if (set.contains(tmp)){
               return tmp;
            }
            tmp = tmp.next;
        }

        return null;
    }

    private static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode preA = headA;
        ListNode preB = headB;
        while (preA != preB){
            preA = preA.next;
            preB = preB.next;
            if (preA == null){
                preA = headB;
            }
            if (preB == null){
                preB = headA;
            }
        }

        return preA;
    }

}

