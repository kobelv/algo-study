package com.kobe.algo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class TrappedWater {
    public static int trap(int[] height){
        int left = 0, right = height.length - 1;
        int result = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max){
                    left_max = height[left];
                } else {
                    result += (left_max - height[left]);
                }
                ++left;
            }
            else {
                if (height[right] >= right_max){
                    right_max = height[right];
                } else {
                    result += (right_max - height[right]);
                }
                --right;
            }
        }
        return result;
    }

    public static String cs(String str1,String str2){
        //转换为字符串数组
        String[] str11=str1.split("");
        String[] str22=str2.split("");
        int[][] record=new int[str11.length][str22.length];
        int maxLen = 0, maxEnd = 0;
        for(int i=0; i<str11.length; i++){
            for (int j = 0; j < str22.length; j++) {
                if (str11[i].equals(str22[j])) {
                    if (i == 0 || j == 0) {
                        //最顶边和最左边设为1
                        record[i][j] = 1;
                    }else {
                        //对角线设成+1的形式
                        record[i][j] = record[i - 1][j - 1] + 1;
                    }
                }else {
                    record[i][j] = 0;
                }
                //如果数组大于最大长度，则将其赋给maxLen
                if (record[i][j] > maxLen) {
                    maxLen = record[i][j];
                    maxEnd = i; //若记录i,则最后获取LCS时是取str1的子串
                }
            }
        }
        return str1.substring(maxEnd-maxLen+1, maxEnd+1);
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        //System.out.println(TrappedWater.trap(arr));

        System.out.println(TrappedWater.cs("abcbced", "acbcbcef"));

    }
}
