package com.kobe.algo;

import java.util.Stack;

public class ValidBracket {
    public static boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }

        Stack<String> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(String.valueOf(s.charAt(i)).equals("(")
                    || String.valueOf(s.charAt(i)).equals("[")
                    || String.valueOf(s.charAt(i)).equals("{")){
                stack.push(String.valueOf(s.charAt(i)));
                continue;
            }
            if((String.valueOf(s.charAt(i)).equals(")")
                && !stack.pop().equals("(")
            ||(String.valueOf(s.charAt(i)).equals("]")
                && !stack.pop().equals("["))
            ||(String.valueOf(s.charAt(i)).equals("}")
                && !stack.pop().equals("{")))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(ValidBracket.isValid("{[()]}"));
    }
}
