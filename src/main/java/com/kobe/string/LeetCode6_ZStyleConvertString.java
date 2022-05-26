package com.kobe.string;

public class LeetCode6_ZStyleConvertString {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(new LeetCode6_ZStyleConvertString().convert(s, 4));
    }

    public String convert(String s, int numRows) {
        String[] tmp = new String[numRows];
        int rowNum = 0, index = 0;
        boolean isIncrease = true;
        for (int i = 0; i < s.length(); i++){
            if (tmp[index] == null){
                tmp[index] = String.valueOf(s.charAt(i));
            } else{
                tmp[index] += s.charAt(i);
            }

            if (index == numRows -1) {
                isIncrease = false;
            } else if (index == 0){
                isIncrease = true;
            }

            if (isIncrease){
                index ++;
            } else{
                index --;
            }

        }

        String result = "";
        for (int j = 0; j < tmp.length; j++){
            result += tmp[j];
        }
        return result;
    }
}
