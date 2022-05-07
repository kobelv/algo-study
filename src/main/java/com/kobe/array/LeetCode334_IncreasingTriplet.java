package com.kobe.array;

/**
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 * 示例 2：
 *
 * 输入：nums = [5,4,3,2,1]
 * 输出：false
 * 解释：不存在满足题意的三元组
 * 示例 3：
 *
 * 输入：nums = [2,1,5,0,4,6]
 * 输出：true
 * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 */
public class LeetCode334_IncreasingTriplet {

    public static void main(String[] args) {
        int[] arr = {2,1,5,0,4,6};
//        int[] arr = {5,4,3,2,1};
//        int[] arr = {1,2,3,4,5};
        System.out.println(new LeetCode334_IncreasingTriplet().increasingTriplet(arr));
        System.out.println(new LeetCode334_IncreasingTriplet().increasingTriplet2(arr));
    }
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3){
            return false;
        }

        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for(int i=1; i<nums.length; i++){
            int tmp = nums[i];
            if (tmp <= first){
                first = tmp;
            } else {
                if (tmp > second){
                    return true;
                } else {
                    second = tmp;
                }
            }
        }
        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        if (nums == null || nums.length < 3){
            return false;
        }
        for(int i=0; i<nums.length -2; i++){
            if (nums[i] < nums[i+1] && nums[i+1] < nums[i+2]){
                return true;
            }
        }

        return false;
    }
}
