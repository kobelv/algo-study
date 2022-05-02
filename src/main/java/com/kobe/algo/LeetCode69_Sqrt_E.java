package com.kobe.algo;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 */
public class LeetCode69_Sqrt_E {

    public static void main(String[] args) {
        System.out.println(sqrt(100000001));
        System.out.println(sqrt2(100000001));
    }

    private static int sqrt(int x){
        if (x==0 || x==1){
            return x;
        }
        for (int i=2; i<x;i++){
            if (i * i > x){
                return i-1;
            }
        }
        return -1;
    }

    private static int sqrt2(int x){
        int l=0, r=x, ans=-1;
        while(l<=r){
            int mid = l+ (r-l)/2;
            if((long) mid*mid <= x){
                ans = mid;
                l = mid+1;
            } else{
                r = mid-1;
            }
        }
        return ans;
    }
}
