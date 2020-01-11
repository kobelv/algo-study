package com.kobe.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集中可能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class LeetCode78_Subset1 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        result.add(new ArrayList<Integer>());
        generate(0, nums, result, item);

        return result;
    }

    private static void generate(int i, int[] nums, List<List<Integer>> result,
                          List<Integer> item) {
        if (i >= nums.length){
            return;
        }
        Integer element = new Integer(nums[i]);
        item.add(element);
        addIntoResult(result, item);

        //两次递归的第一次：考虑i位置上的元素
        generate(i+1, nums, result, item);

        //两次递归的第二次：下面两句是不考虑i位置上的元素
        item.remove(element);
        generate(i+1, nums, result, item);
    }

    public static void addIntoResult(List<List<Integer>> result,
                                     List<Integer> item){
        if (item == null || item.isEmpty()){
            return;
        }
        List<Integer> tmp = new ArrayList<>(item.size());
        for (int i=0; i<item.size();i++){
            tmp.add(item.get(i));
        }
        result.add(tmp);
    }

    public static void main(String[] args) {
        int[] nums = {2,1,2,2};
        List<List<Integer>> subsets = subsets(nums);
        for (int i=0; i<subsets.size();i++){
            for(int j=0; j<subsets.get(i).size();j++){
                System.out.print(subsets.get(i).get(j)+"--");
            }
            System.out.println();
        }
    }
}
