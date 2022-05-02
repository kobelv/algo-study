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

    public static ListNode buildCircleList(int[] arr, int n){
        ListNode head = null, preNode = null, tmpNode = null;
        for(int i=0; i<arr.length; i++){
            ListNode node = new ListNode(arr[i]);
            if(i == 0){
                head = node;
                preNode = node;
                continue;
            }

            preNode.next = node;
            preNode = preNode.next;

            if (i == n -1){
                tmpNode = node;
            }

            if (i == arr.length -1){
                preNode.next = tmpNode; //build a circle
            }
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
