package com.kobe.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」 定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 * 示例 1：
 *
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 1*1 + 9*9 = 82
 * 8*8 + 2*2 = 68
 * 6*6 + 8*8 = 100
 * 1*1 + 0*0 + 0*0 = 1
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：false
 */
public class LeetCode_202_HappyNum {
    public static void main(String[] args) {
        System.out.println(isHappy(289));
    }

    private static boolean isHappy(int n){
        Set<Integer> set = new HashSet<Integer>();
        while(n != 1 && !set.contains(n)){
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private static int getNext(int n){
        int sum = 0;
        while(n >0){
            int d = n % 10;
            sum += d*d;
            n /= 10;
        }
        return sum;
    }


    private static boolean calc(int n){
        int sum = 0;
        int times = 0;
        while(n != 1){
            while(n >0){
                sum += (n%10)*(n%10);
                n /= 10;
                if (sum == 1){
                    return true;
                }

                if(n == 0){
                    times ++;
                    n = sum;
                    sum = 0;
                }

                if (times == 100){
                    return false;
                }
            }
        }
        return true;
    }
}
