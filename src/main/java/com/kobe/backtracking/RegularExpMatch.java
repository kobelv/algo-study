package com.kobe.backtracking;

public class RegularExpMatch {
    char[] pattern;
    boolean isMatched = false;

    public RegularExpMatch(char[] str){
        this.pattern = str;
    }

    public boolean match(char[] text){
        matchInternal(text, 0, 0);
        return isMatched;
    }

    private void matchInternal(char[] text, int textIndex, int patternIndex) {
        //终止条件1
        if (isMatched){
            return;
        }
        //终止条件2
        if (patternIndex == pattern.length &&
            textIndex == text.length){
            isMatched = true;
            return;
        }

        //终止条件3
        if (textIndex >= text.length || patternIndex >= pattern.length){
            return;
        }

        if (pattern[patternIndex] == '*'){
            //*表示能匹配任意字符，这里的理解有点难度
            for(int i=0; i<text.length-textIndex;i++){
                //i==0,表示*匹配0个字符，跳到模式串下一个字符和字符串当前字符比较，如果不匹配
                //跳到i=1，表示*匹配1个字符，跳到模式串下一个字符和字符串下1个字符比较，如果不匹配
                //跳到i=2，表示*匹配2个字符，跳到模式串下一个字符和字符串下2个字符比较，以此类推。。。
                if (isMatched){
                    //省去不必要的循环
                    break;
                }
                matchInternal(text, textIndex+i, patternIndex+1);
            }
        } else if (pattern[patternIndex] == '?'){
            //?表示能匹配两种情况，一种是0个字符
            matchInternal(text, textIndex, patternIndex+1);
            //另一种是1个字符
            matchInternal(text, textIndex+1, patternIndex+1);
        } else if (pattern[patternIndex] == text[textIndex]){
            //非特殊字符，则直接比较模式串和字符串的相应字符
            matchInternal(text, textIndex+1, patternIndex+1);
        }
    }

    public static void main(String[] args) {
        RegularExpMatch reg = new RegularExpMatch("*A?B".toCharArray());
        reg.match("AdafafABC".toCharArray());
        /**
         * AdafafABC = false
         * AdafafAB = true
         * AdafafACB = true
         */
        System.out.println(reg.isMatched);
    }
}
