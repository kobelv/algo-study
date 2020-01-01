package com.kobe.algo;

import com.kobe.linkedlist.ListNode;
import com.kobe.linkedlist.ListUtil;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[j]+nums[i] == target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No qualified result");
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 该方法空间换时间
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Integer in = new Integer("12") + new Integer("2");
        System.out.println(in);

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int diff = target - nums[i];
            if (map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No qualified result");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        while(l1 != null){
            sb1.append(l1.val);
            l1=l1.next;
        }
        StringBuilder sb2 = new StringBuilder();
        while(l2 != null){
            sb2.append(l2.val);
            l2=l2.next;
        }

        String str1 = sb1.reverse().toString();
        String str2 = sb2.reverse().toString();

        Integer tmpResult1 = null;
        Integer tmpResult2 = null;
        if(str1 != null){
            tmpResult1 = new Integer(str1);
        }
        if(str2 != null){
            tmpResult2 = new Integer(str2);
        }

        String result = String.valueOf(tmpResult1 + tmpResult2);
        ListNode head = null;
        ListNode preNode = null;
        for(int i=result.length()-1; i>=0; i--){
            ListNode node = new ListNode(result.charAt(i)-'0');
            if(i==result.length()-1){
                head = node;
                preNode = node;
                continue;
            }
            preNode.next = node;
            preNode = preNode.next;
        }
        return head;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int sum, carry=0;
        ListNode head = null;
        ListNode preNode = null;
        boolean isFirst = true;
        while (l1 != null && l2 != null){
            sum = l1.val+l2.val+carry;
            carry = sum/10;
            ListNode node = new ListNode(sum%10);
            if (isFirst){
                isFirst = false;
                head = node;
                preNode = head;
            }
            preNode.next = node;
            preNode = preNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null){
            sum = l1.val+carry;
            carry = sum/10;
            ListNode node = new ListNode(sum%10);
            preNode.next = node;
            preNode = preNode.next;
            l1 = l1.next;
        }

        while(l2 != null){
            sum = l2.val+carry;
            carry = sum/10;
            ListNode node = new ListNode(sum%10);
            preNode.next = node;
            preNode = preNode.next;
            l2 = l2.next;
        }

        if (carry != 0){
            ListNode node = new ListNode(carry);
            preNode.next = node;
        }

        return head;
    }

    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,9};
        System.out.println(Arrays.toString(TwoSum.twoSum(arr, 9)));
        System.out.println(Arrays.toString(TwoSum.twoSum2(arr, 9)));

        int[] arr2 = {9,6,5};
        int[] arr3 = {8,7};
        ListUtil.printList(
                TwoSum.addTwoNumbers(ListUtil.buildList(arr2),
                        ListUtil.buildList(arr3)));
        ListUtil.printList(TwoSum.addTwoNumbers2(ListUtil.buildList(arr2),
                ListUtil.buildList(arr3)));

        ListUtil.printList(TwoSum.addTwoNumbers3(ListUtil.buildList(arr2),
                ListUtil.buildList(arr3)));
    }
}
