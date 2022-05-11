package com.kobe.array;

import java.util.*;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class LeetCode46_AllOrders {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(new LeetCode46_AllOrders().permute(arr));
    }
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        boolean[] used = new boolean[length];
        List<List<Integer>> res = new ArrayList<>();

        Deque<Integer> output = new ArrayDeque<>();
        dfs(output, nums, used, 0, length, res);

        return res;
    }

    private void dfs(Deque<Integer> thisRound, int[] nums, boolean[] used,
                     int position, int length,List<List<Integer>> res){
        if (position == length){
            res.add(new ArrayList<>(thisRound));
            return;
        }
        for (int i=0; i<length; i++){
            if (!used[i]) {
                thisRound.add(nums[i]);
                used[i] = true;

                dfs(thisRound, nums, used, i+1, length, res);

                used[i] = false;
                thisRound.removeLast();
            }
        }
    }
}
