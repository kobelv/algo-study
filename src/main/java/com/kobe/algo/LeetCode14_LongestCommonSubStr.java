package com.kobe.algo;

/**
 * 编写一个函数来查找字符串数组中的最长公共子串。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["aflower","abflow","aflight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 */
public class LeetCode14_LongestCommonSubStr {

    public static void main(String[] args){
        //String[] arr = {"afl1","bbfl","flfl"};
        String[] arr = {"abfab","fabd","afabedd"};
        System.out.print(find(arr));

    }

    private static String find(String[] arr){
        if(arr == null){
            return "";
        }
        if(arr.length == 1){
            return arr[0];
        }
        String s1=arr[0];
        String s2=arr[1];
        String result="", tmpResult="";
        int start=0, length=0,tmpLength=0;
        for(int i=0; i<s1.length();i++){
            char c=s1.charAt(i);
            for(int j=start; j< s2.length();j++){
                if (c == s2.charAt(j)){
                    tmpResult += c;
                    start = j+1;
                    tmpLength++;
                    break;
                } else if(tmpLength>0){
                    if(tmpLength > length){
                        length = tmpLength;
                        tmpLength = 0;
                        result = tmpResult;
                        tmpResult="";

                    }
                    start = 0;
                }
            }

        }

        if(tmpLength > length){
            length = tmpLength;
            tmpLength = 0;
            result = tmpResult;
            tmpResult="";

        }

        //build new array
        String[] newArr = new String[arr.length-1];
        newArr[0]=result;
        for(int i=2; i<arr.length;i++){
            newArr[i-1]=arr[i];
        }

        return find(newArr);
    }

}
