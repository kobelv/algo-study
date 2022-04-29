package com.kobe.algo;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 *
 */
public class LeetCode20_ValidBracket_E {
    public static void main(String[] args){
        String s="{[((]}";
        System.out.print(isValid(s));
    }

    private static boolean isValid(String s){
        if (s == null || s.length()%2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        char c;
        for (int i=0; i<s.length();i++){
            c = s.charAt(i);
            if (map.containsKey(c)){
                if (stack.empty() || stack.peek()!= map.get(c)){
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return true;
    }
}
