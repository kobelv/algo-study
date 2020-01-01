package com.kobe.linkedlist;

public class ListUtil {

    public static ListNode buildList(int[] arr){
        ListNode head = null;
        ListNode preNode = null;
        for(int i=arr.length-1; i>=0; i--){
            ListNode node = new ListNode(arr[i]);
            if(i==arr.length-1){
                head = node;
                preNode = node;
                continue;
            }
            preNode.next = node;
            preNode = preNode.next;
        }
        return head;
    }

    public static void printList(ListNode head){
        ListNode tmpNode = head;
        while(tmpNode != null){
            System.out.print(tmpNode.val + "->");
            tmpNode = tmpNode.next;
        }
        System.out.println();
    }
}
