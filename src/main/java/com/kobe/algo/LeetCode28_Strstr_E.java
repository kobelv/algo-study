package com.kobe.algo;

/**
 * 实现 strStr() 函数。类似C语言的 strstr() 以及 Java的 indexOf()
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 */
public class LeetCode28_Strstr_E {

    public static void main(String[] args){
        System.out.println(strstr("heloll","ll"));
    }

    public static int strstr(String haystack, String needle){
        int n=haystack.length(), m=needle.length();
        for (int i =0; i+m<=n;i++){
            boolean found = true;
            for(int j=0; j<m;j++){
                if (haystack.charAt(i+j) != needle.charAt(j)){
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

    public static int strstr(String longS, int lStart, String shortS){
        if (shortS == null || shortS.length() > longS.length()){
            return -1;
        }

        int p=-1;
        for(int i=0; i<shortS.length(); i++){
            for (int j=lStart; j<longS.length();j++){
                if (shortS.charAt(i) == longS.charAt(j)){
                    if (i ==0){
                        p=j;//first position
                    }
                    lStart=j+1;
                    break;
                }

                if(i != 0){
                    return strstr(longS, lStart, shortS);
                }
            }

        }
        return p;
    }
}
