package com.kobe.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: 0
 *
 * 示例 3：
 * 输入: s = "aabb"
 * 输出: -1
 * */
public class LeetCode387_FindUniqueChar {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(find(s));
        System.out.println(find2(s));
    }

    private static int find(String s){
        if (s == null){
            return -1;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                map.put(c, map.get(c)+1);
            } else{
                map.put(c, 1);
            }
        }

        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (map.get(c) == 1){
                return i;
            }
        }

        return -1;
    }

    private static int find2(String s){
        for (int i=0; i<s.length(); i++){
            boolean found = true;
            for (int j=i+1; j<s.length(); j++){
                if (s.charAt(i) == s.charAt(j)){
                    found = false;
                    break;
                }
            }
            if (found){
                return i;
            }
        }

        return -1;
    }
}
