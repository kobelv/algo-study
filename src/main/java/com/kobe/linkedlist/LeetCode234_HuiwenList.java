package com.kobe.linkedlist;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */

public class LeetCode234_HuiwenList {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,1};
        ListNode head= ListUtil.buildList(arr);
        System.out.println(isPalindrome2(head));
    }

    //转成数组再判断回文
    private static boolean isPalindrome(ListNode head) {
        List<Integer> arr = new ArrayList<Integer>();
        ListNode tmp = head;
        while(tmp != null){
            arr.add(tmp.val);
            tmp = tmp.next;
        }

        int first = 0, last = arr.size()-1;
        while(first < last){
            if(!arr.get(first).equals(arr.get(last))){
                return false;
            }
            first ++;
            last --;
        }

        return true;
    }

    //反转后半个链表法
    private static boolean isPalindrome2(ListNode head) {
        ListNode mid = getMidNode(head);
        ListNode newHead = reverseList(mid);
        while(newHead != null && head != null){
            if (newHead.val == head.val){
                newHead = newHead.next;
                head = head.next;
            }
        }

        if (newHead == null || head == null){
            return true;
        }

        return false;
    }

    private static ListNode getMidNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverseList(ListNode head){
        ListNode  pre = null, curr = head, tmp = null;
        while (curr != null){
            tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }

        return pre;
    }
}
