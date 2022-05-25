package com.kobe.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode611_HowManyTriangle {

    public static void main(String[] args) {

        int[] arr = {4, 2, 3, 4};
        System.out.println(new LeetCode611_HowManyTriangle().triangleNumber(arr));
    }

    public int triangleNumber(int[] nums) {
        if(nums == null || nums.length < 3){
            return 0;
        }

        Arrays.sort(nums);
        int count = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i<nums.length -2; i++){
            int a = nums[i], b = nums[i+1];
            for(int j = i+2; j < nums.length; j++){
                if (isValidTriangle(a, b, nums[j])){
                    count ++;
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(a);
                    tmp.add(b);
                    tmp.add(nums[j]);
                    result.add(tmp);
                }
            }
        }
        for (List<Integer> i : result) {
            for(Integer j : i){
                System.out.println(j);
            }
            System.out.println();
        }

        return count;
    }

    private boolean isValidTriangle(int a, int b, int c){
        if (!(a >0 && b > 0 && c > 0)){
            return false;
        }

        if (a + b > c && a + c > b && b + c > a){
            return true;
        }

        return false;
    }
}
