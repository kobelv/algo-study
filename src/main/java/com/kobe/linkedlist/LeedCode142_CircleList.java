package com.kobe.linkedlist;

public class LeedCode142_CircleList {
    public static void main(String[] args) {
        int arr[] = {5,7,9,-1};
        ListNode head = ListUtil.buildCircleList(arr, 3);

        System.out.println(hasCircle(head));
        System.out.println(findCircle(head) == null
                ? "no circle" : findCircle(head).val);

    }

    private static boolean hasCircle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(true){
            slow = slow.next;
            if (fast.next != null){
                fast = fast.next.next;
            } else{
                return false;
            }
            if(slow == fast){
                break;
            }
        }

        return true;
    }

    private static ListNode findCircle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
            slow = slow.next;
            if (fast.next != null){
                fast = fast.next.next;
            } else {
                return null;
            }

            if (fast == slow){
                ListNode tmp = head;
                while(tmp != slow){
                    tmp = tmp.next;
                    slow = slow.next;
                }

                return tmp;
            }
        }

        return null;
    }

}
