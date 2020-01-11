package com.kobe.backtracking;

import java.util.*;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）
 *
 * 说明：解集不能包含重复的子集。【注意：这是跟LeetCode78_Subset1的区别】
 * 【2，1，2】和【1，2，2】是重复的
 *
 * 思路：原数组排序，同时用set保持所有结果并去重
 */
public class LeetCode78_Subset2 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        //数组排序
        Arrays.sort(nums);
        result.add(new ArrayList<Integer>());
        generate2(0, nums, result, item, set);

        return result;
    }

    private static void generate2(int i, int[] nums, List<List<Integer>> result,
                          List<Integer> item,Set<List<Integer>> set) {
        if (i >= nums.length){
            return;
        }
        Integer element = new Integer(nums[i]);
        item.add(element);
        if (!set.contains(item)){
            LeetCode78_Subset1.addIntoResult(result, item);
            set.add(item);
        }

        //两次递归的第一次：考虑i位置上的元素
        generate2(i+1, nums, result, item, set);

        //两次递归的第二次：下面两句是不考虑i位置上的元素
        item.remove(element);
        generate2(i+1, nums, result, item, set);
    }

    public static void main(String[] args) {
        int[] nums = {2,1,2,2};
        List<List<Integer>> subsets = LeetCode78_Subset2.subsets(nums);
        for (int i=0; i<subsets.size();i++){
            for(int j=0; j<subsets.get(i).size();j++){
                System.out.print(subsets.get(i).get(j)+"--");
            }
            System.out.println();
        }
    }
}
