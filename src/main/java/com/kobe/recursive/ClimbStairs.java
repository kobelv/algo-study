package com.kobe.recursive;

import com.kobe.array.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 解题思路：从第一步的走法考虑，有两种情况：
 * 1. 第一步要么先走一个台阶，则剩下的n-1个台阶的方法就是情况1的方法种数
 * 2. 第一步要么先走两个台阶，则剩下的n-2个台阶的方法就是情况2的方法种数
 *
 * case 1： 假设有1个台阶，则有1种方法
 *  1 阶
 *
 *  case 2： 假设有2个台阶，则有2种方法
 *  1 阶 + 1 阶
 *  2 阶
 *
 *  case 3：假设有3个台阶，则有3种方法
 *  （1阶） + 2阶               --- 这是case 1的方法
 *
 *  （1 阶 + 1 阶） + 1 阶       --- 这是case 2的方法
 *  （2阶） + 1阶               --- 这是case 2的方法
 *
 *  case 4：假设有4个台阶，则有？方法
 *  （1 阶 + 1 阶） + 2阶
 *  （2 阶） + 2阶
 *
 *  （1 阶 + 1 阶 + 1 阶） + 1阶
 *  （1阶 + 2阶） + 1阶
 *  （2阶 + 1阶）+1阶
 */
public class ClimbStairs {

    public static HashMap<Long, Long> bufferedResult = new HashMap<>();
    public static long calcSteps(long n){
        if (n == 1){
            return 1;
        }

        if (n == 2){
            return 2;
        }

        return calcSteps(n-2)+calcSteps(n-1);
    }

    public static long calcStepsOptimized(long n){
        /**
         * 递归算法里很重要的一点是要避免重复计算。就跟回溯算法里需要剪枝一样。
         *
         * 该方法比起calcSteps()有巨大的效率提升
         */
        if (n == 1){
            return 1;
        }

        if (n == 2){
            return 2;
        }

        if (bufferedResult.containsKey(n)){
            return bufferedResult.get(n);
        }

        long result = calcStepsOptimized(n-2)+calcStepsOptimized(n-1);
        bufferedResult.put(n, result);
        return result;
    }

    public static ArrayList<String> stepRecords(int n){
        if (n == 1){
            ArrayList<String> stepRecord = new ArrayList<>();
            stepRecord.add("1阶");
            return stepRecord;
        }

        if (n == 2){
            ArrayList<String> stepRecord = new ArrayList<>();
            stepRecord.add("1阶--1阶");
            stepRecord.add("2阶");
            return stepRecord;
        }

        ArrayList<String> finalList = new ArrayList<>();
        ArrayList<String> list1 = stepRecords(n-1);
        for (int i=0; i<list1.size();i++){
            finalList.add("1阶--"+list1.get(i));
        }
        ArrayList<String> list2 = stepRecords(n-2);
        for (int j=0; j<list2.size();j++){
            finalList.add("2阶--"+list2.get(j));
        }

        return finalList;
    }

    public static void main(String[] args) {
        int n=6;
//        long start = System.currentTimeMillis();
//        System.out.println(ClimbStairs.calcSteps(n));
//        long end = System.currentTimeMillis();
//        System.out.println("time costs: " + (end-start));
//
//        long start2 = System.currentTimeMillis();
//        System.out.println(ClimbStairs.calcStepsOptimized(n));
//        long end2 = System.currentTimeMillis();
//        System.out.println("time costs: " + (end2-start2));

        ArrayUtils.printResults(ClimbStairs.stepRecords(n));
    }
}
