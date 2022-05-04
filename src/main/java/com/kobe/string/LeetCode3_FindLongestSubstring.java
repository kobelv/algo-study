package com.kobe.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class LeetCode3_FindLongestSubstring {
    public static void main(String[] args) {
        //String s = "abcabcbb";
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    //滑动窗口法
    private static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int right = -1, maxLength = 0;
        for (int i=0; i<s.length(); i++){
            //i是窗口的左侧，right是窗口的右边
            if (i > 0){
                set.remove(s.charAt(i-1));
            }

            while (right+1 < s.length() && !set.contains(s.charAt(right+1))){
                set.add(s.charAt(right+1));
                right ++;
            }

            maxLength = Math.max(right - i +1, maxLength);
        }

        return maxLength;
    }
}
