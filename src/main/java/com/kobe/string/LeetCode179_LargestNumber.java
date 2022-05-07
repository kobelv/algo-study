package com.kobe.string;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 */
public class LeetCode179_LargestNumber {
    public static void main(String[] args) {
        int[] arr = {3,30,34,5,9};
//        int[] arr = {10,2};
        System.out.println(new LeetCode179_LargestNumber().largestNumber(arr));
    }

    public String largestNumber(int[] nums) {
        if (nums == null){
            return "";
        }
        String result = "";
        String maxS = "";
        int position = 0;
        for (int i=0; i<nums.length; i++){
            position = i;
            maxS = String.valueOf(nums[i]);
            for (int j=i+1; j<nums.length; j++){
                String s2 = String.valueOf(nums[j]);
                maxS = findMax(maxS, s2);
                if (maxS.equals(s2)){
                    position = j;
                }
            }
            result +=  String.valueOf(nums[position]);
            if (position != i){
                int tmp = nums[position];
                nums[position] = nums[i];
                nums[i] = tmp;
            }
        }
        return result;
    }

    private String findMax(String s1, String s2){
        int i1 = Integer.valueOf(s1+s2).intValue();
        int i2 = Integer.valueOf(s2+s1).intValue();
        return i1 > i2 ? s1 : s2;
    }

    private String findMax2(String s1, String s2){
        int i = 0;
        while (i < s1.length() && i < s2.length()){
            if (s1.charAt(i) == s2.charAt(i)){
                i++;
            } else {
                return s1.charAt(i) > s2.charAt(i) ? s1 : s2;
            }
        }
        if (i >= s1.length()){
            return s2.charAt(i) == '0' ? s1 : s2;
        }

        if (i >= s2.length()){
            return s1.charAt(i) == '0' ? s2 : s1;
        }

        return "";
    }
}
