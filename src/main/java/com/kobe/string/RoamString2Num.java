package com.kobe.string;

public class RoamString2Num {
    public static void main(String[] args) {
        String input = "LVIII";
        transfer(input);
        transfer2(input);
    }

    public static void transfer2(String s){
        int sum = 0;

        int preV = getValue(s.charAt(0));
        int currentV=0;
        for(int i=1; i<s.length();i++){
            currentV = getValue(s.charAt(i));
            if (preV < currentV){
                sum -= preV;
            }
            if(preV > currentV){
                sum += preV;
            }

            preV = currentV;
        }

        sum += preV;
        System.out.println(sum);
    }

    public static void transfer(String s){
        //IV=4,IX=9
        //XL=40,XC=90
        //CD=400,CM=900
        int sum=0;
        //special case
        boolean flag = true;
        while(flag){
            flag = false;
            if(s.contains("CM")){
                sum += 900;
                s= s.replaceFirst("CM", "");
                flag = true;
            }
            if(s.contains("CD")){
                sum += 400;
                s= s.replaceFirst("CD", "");
                flag = true;
            }
            if(s.contains("XC")){
                sum += 90;
                s= s.replaceFirst("XC", "");
                flag = true;
            }
            if(s.contains("XL")){
                sum += 40;
                s= s.replaceFirst("XL", "");
                flag = true;
            }
            if(s.contains("IX")){
                sum += 9;
                s= s.replaceFirst("IX", "");
                flag = true;
            }
            if(s.contains("IV")){
                sum += 4;
                s= s.replaceFirst("IV", "");
                flag = true;
            }
        }


        //normal case
        for(int i=0; i<s.length();i++){
            switch (s.charAt(i)){
                case 'I':
                    sum += 1;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    sum += 10;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    sum += 100;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;

                default:
                    break;
            }
        }
        System.out.println(sum);
    }

    private static int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;

            case 'X':
                return 10;

            case 'L':
                return 50;

            case 'C':
                return 100;

            case 'D':
                return 500;

            case 'M':
                return 1000;


            default:
                return 0;
        }
    }
}
