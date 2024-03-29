package com.kobe.array;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class LeetCode15_ThreeSum_M {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(arr);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length<3){
            return null;
        }

        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        for (int i=0; i<nums.length; i++){
            if (i-1 > 0 && nums[i] == nums[i-1]){
                continue;
            }
            ans = merge(ans, twoSum(nums, -nums[i], i), nums[i]);
        }
        return ans;
    }

    public static List<List<Integer>> twoSum(int[] nums, int sum, int excludeIndex) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i == excludeIndex){
                continue;
            }
            if (map.containsKey(nums[i])){
                List<Integer> list = new LinkedList<>();
                list.add(nums[i]);
                list.add(map.get(nums[i]));
                ans.add(list);
            } else{
                map.put(sum - nums[i], nums[i]);
            }
        }
        return ans;
    }

    public static List<List<Integer>> merge(List<List<Integer>> originList,
                                            List<List<Integer>> newList, int i){
        for(List l : newList){
            l.add(i);
            if (!originList.contains(l)){
                //没有达到去重效果，//todo
                originList.add(l);
            }
        }

        return originList;
    }
}
