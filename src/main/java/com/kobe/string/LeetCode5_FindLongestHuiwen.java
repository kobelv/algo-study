package com.kobe.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 */
public class LeetCode5_FindLongestHuiwen {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(find(s));
    }

    private static String find(String s){
        Set<Character> set = new HashSet<Character>();
        int right = -1;
        for (int i=0; i<s.length(); i++){

        }
        return "";
    }
}
