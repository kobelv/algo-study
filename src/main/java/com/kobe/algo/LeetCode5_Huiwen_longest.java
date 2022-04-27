package com.kobe.algo;

/**
 * 回文整数
 *
 *
 * 示例 1：
 *
 * 输入: -10
 * 输出: false
 *
 * 示例 2：
 * 输入: 121
 * 输出: true
 */
public class LeetCode5_Huiwen_longest {

    public static void main(String[] args){
        int i= 1221;
        String s="abcdcba";
        System.out.println("通过字符串回文方式："+isPalindrome(String.valueOf(i)));
        System.out.println("通过反转一半数字："+isPalindrome(i));
        System.out.println("通过字符串回文方式："+isPalindrome(s));
    }

    //回文整数
    //123-->false
    //121-->true
    //123321
    public static boolean isPalindrome(String s) {
        for (int i=0, j=s.length()-1; i<s.length()&&i<=j; i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }

    return true;
    }

    public static boolean isPalindrome(int x) {
        if(x<0 || (x%10==0&&x!=0)){
            return false;
        }

        //123
        int reversedNum = 0;
        while(x > reversedNum){
            reversedNum = reversedNum*10 + x%10;
            x /= 10;
        }

        if(x == reversedNum || x == reversedNum/10){
            return true;
        }

        return false;
    }
}
