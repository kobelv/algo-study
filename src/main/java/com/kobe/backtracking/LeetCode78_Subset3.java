package com.kobe.backtracking;

import java.util.*;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集），其中
 * 1）解集不能包含重复的子集。
 * 2）且子集之和=target【注意：这题在LeetCode78_Subset2基础上加上了求和条件】
 *
 *
 * 思路：
 * 1. 回溯法，当前元素包含和不包含两种情况都要考虑
 * 2. 原数组排序，同时用set保持所有结果并去重，如果子集的和等于target就是符合要求的子集，
 * 3. 回溯法的复杂度是2^n，相当高，要尽可能考虑剪枝条件。这个例子里可以加上一个剪枝条件：
 * 如果大于target不用继续递归（做剪枝）
 */
public class LeetCode78_Subset3 {
    public static List<List<Integer>> subsets(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        //数组排序
        Arrays.sort(nums);
        result.add(new ArrayList<Integer>());
        generate3(0, nums, result, item, set, 0, target);

        return result;
    }

    private static void generate3(int i, int[] nums, List<List<Integer>> result,
                          List<Integer> item,Set<List<Integer>> set, int sum, int target) {
        if (i >= nums.length || sum>target){
            //多了一个剪枝条件sum>target
            return;
        }
        Integer element = new Integer(nums[i]);
        item.add(element);
        sum += element.intValue();
        if (!set.contains(item) && sum == target){
            LeetCode78_Subset1.addIntoResult(result, item);
            set.add(item);
        }

        //两次递归的第一次：考虑i位置上的元素
        generate3(i+1, nums, result, item, set, sum, target);

        //两次递归的第二次：下面是不考虑i位置上的元素
        sum -= element.intValue();
        item.remove(element);
        generate3(i+1, nums, result, item, set, sum, target);
    }

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        List<List<Integer>> subsets = LeetCode78_Subset3.subsets(nums, 8);
        for (int i=0; i<subsets.size();i++){
            for(int j=0; j<subsets.get(i).size();j++){
                System.out.print(subsets.get(i).get(j)+"--");
            }
            System.out.println();
        }
    }
}
