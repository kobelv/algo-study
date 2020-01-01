package com.kobe.recursive;

/**
 * 求阶乘
 */
public class Factorial {
    public static long calcFactorial(int n){
        if(n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }

        return n*calcFactorial(n-1);
    }

    public static void main(String[] args) {
        //System.out.println(Factorial.calcFactorial(5));
        System.out.println(Factorial.calcFactorial(10-4));
    }
}
