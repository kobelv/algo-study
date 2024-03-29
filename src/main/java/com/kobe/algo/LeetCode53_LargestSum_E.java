package com.kobe.algo;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 */
public class LeetCode53_LargestSum_E {
    public static void main(String[] args){
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(find(arr));
    }

    public static int find(int[] num){
        int ans=num[0], pre=0;
        for(int i : num){
            pre = Math.max(pre+i,i);//比较：前一个位置上的最大和 vs 我自己
            ans = Math.max(pre, ans);
        }
        return ans;
    }


}
