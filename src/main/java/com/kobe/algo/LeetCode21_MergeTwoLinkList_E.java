package com.kobe.algo;


import com.kobe.linkedlist.ListNode;

import static com.kobe.linkedlist.ListUtil.buildList;
import static com.kobe.linkedlist.ListUtil.printList;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 */
public class LeetCode21_MergeTwoLinkList_E {
    public static void main(String[] args){
        int[] arr1={1,2,4,5,6};
        int[] arr2={1,3,4};
        ListNode result = mergeTwoLists(buildList(arr1),
                buildList(arr2));

        printList(result);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tmp = new ListNode();
        head = tmp;
        while(list1 != null && list2 != null){
            if (list1.val <= list2.val){//拼接list1
                tmp.next = list1;
                list1 = list1.next;

            } else{//拼接list2
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }

        //还有未拼完的那个
        if(list1 != null){
            tmp.next = list1;
        }
        if(list2 != null){
            tmp.next = list2;
        }

        return head.next;
    }
}
