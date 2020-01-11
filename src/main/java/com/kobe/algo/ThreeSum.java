package com.kobe.algo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ThreeSum {
    //暴力法：O(n^3)
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                //固定两个人后，去找第三个人
                for (int k=j+1; k<nums.length; k++){
                    if (nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> candidate = new ArrayList<>();
                        candidate.add(nums[i]);
                        candidate.add(nums[j]);
                        candidate.add(nums[k]);
                        result.add(candidate);
                    }
                }
            }
        }
        return result;
    }

    //高效法 O(n^2)
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //先排序
        Arrays.sort(nums);
        //固定一个数字后，找其他两个
        for (int i=0; i<nums.length; i++){
            if (nums[i] >0){
                //从正数开始往后的数都>0，没必要继续了
                break;
            }

            if (i>1 && nums[i]== nums[i-1]){
                //连续一样的数，不用考虑了，否则就是重复结果
                continue;
            }

            int start = i+1;
            int end = nums.length-1;
            // 三数之和>0，则说明，end端的数字太大了，end端需要移动
            // 三数之和<0，则说明，start端的数字太小了，start端需要移动
            while (start<end){
                if (nums[start]+nums[end]+nums[i] > 0){
                    end --;
                } else if  (nums[start]+nums[end]+nums[i] < 0){
                    start++;
                } else {
                    List<Integer> candidate = new ArrayList<>();
                    candidate.add(nums[i]);
                    candidate.add(nums[start++]);
                    candidate.add(nums[end--]);
                    result.add(candidate);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        ThreeSum.threeSum(arr);
        ThreeSum.threeSum2(arr);

    }
}
