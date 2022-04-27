package com.kobe.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class LeetCode1_TwoSum_E {
    public static void main(String[] args) {

        int arr[]={-1,11,7,15};
        int target =6;
        match(arr, target);
        match2(arr, target);

    }

    private static void match(int [] arr, int target){
        if(arr == null){
            return;
        }
        for (int i=0; i<arr.length;i++){
            //j前面的已经尝试匹配过了
            for(int j=i+1; j<arr.length; j++){
                if (j == i){
                    continue;
                }
                if (arr[j] + arr[i] == target){
                    System.out.println("match() returns: "+ i + " and " + j);
                    return;
                }
            }
        }
    }

    private static void match2(int [] arr, int target){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<arr.length;i++){
            if (map.containsKey(arr[i])){
                System.out.println("match2() returns: "+ map.get(arr[i]) + " and " + i);
                return;
            } else{
                map.put(target - arr[i], i);
            }

        }
    }
}
