package com.kobe.algo;

/**
 * 回文字符串或回文整数
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LeetCode5_Huiwen {

    public static void main(String[] args){
        int i= 1221;
        String s="";
        System.out.println("通过字符串回文方式："+isPalindrome(String.valueOf(i)));
        System.out.println("通过反转一半数字："+isPalindrome(i));
        System.out.println("通过字符串回文方式："+isPalindrome(String.valueOf(s)));
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
