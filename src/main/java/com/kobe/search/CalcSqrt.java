package com.kobe.search;

/**
 * 求x的平方根
 *
 * 算法思路：用二分法逼近
 */
public class CalcSqrt {

    public static long calcSqrt(long x){
        if (x == 1){
            return 1;
        }

        long left = 1;
        long right = x;
        long mid = (right+left)/2;
        for (;right-left>1;mid=(right+left)/2){
            if (mid * mid == x){
                break;
            } else if (mid*mid > x){
                right = mid;
            } else {
                left = mid;
            }
        }
        return mid;
    }

    public static double calcSqrt2(double x, double precision) {
        if (x < 0) {
            return Double.NaN;
        }
        double low = 0;
        double up = x;
        if (x < 1 && x > 0) {
        /** 小于1的时候*/
            low = x;
            up = 1;
        }
        double mid = low + (up - low)/2;
        while(up - low > precision) {
            if (mid * mid > x ) {//TODO mid可能会溢出
                up = mid;
            } else if (mid * mid < x) {
                low = mid;
            } else {
                return mid;
            }
            mid = low + (up - low)/2;
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(CalcSqrt.calcSqrt(4));
        System.out.println(CalcSqrt.calcSqrt2(2, 6));

    }

}
