package com.kobe.algo;

public class LongestBracket {
    public static int longestValidParentheses(String s) {
        if(s == null){
            return 0;
        }

        int left=0, right=0;
        int maxLength=-1;
        for(int i=0; i<s.length(); i++){
            if (s.charAt(i) == '('){
                left++;
            } else{
                right++;
            }
            if(left == right && maxLength < right*2){
                maxLength = right*2;
            }
            if (right > left){
                left=right=0;
            }
        }

        left=right=0;
        for(int j=s.length()-1; j>=0; j--){
            if (s.charAt(j) == ')'){
                left++;
            } else{
                right++;
            }
            if(left == right && maxLength < right*2){
                maxLength = right*2;
            }
            if (right > left){
                left=right=0;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(LongestBracket.longestValidParentheses("(()"));
    }
}
