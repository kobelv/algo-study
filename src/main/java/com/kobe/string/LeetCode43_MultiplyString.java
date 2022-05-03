package com.kobe.string;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 *
 */
public class LeetCode43_MultiplyString {
    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "456";
        System.out.println(multiply(s1, s2));
    }

    private static String multiply(String num1, String num2) {
        int m1 = num1.length(), m2 = num2.length();
        int sum = 0, tmpSum = 0, tmp = 0, carry = 0;
        for (int i=m1-1; i>=0; i--){
            int n1 = num1.charAt(i) - '0';
            tmpSum = 0;
            //3*55
            for (int j=m2-1; j>=0; j--){
                int n2 = num2.charAt(j) - '0';
                tmp = (n1*n2)%10 + carry;
                carry = (n1*n2)/10;
                int k = m2-1-j;
                while (k > 0){
                    tmp *= 10;
                    k--;
                }
                tmpSum += tmp;
            }
            if (carry > 0){
                int k = m2;
                while (k > 0){
                    carry *= 10;
                    k--;
                }
            }

            tmpSum += carry;
            carry = 0;

            int k = m1-1-i;
            while(k > 0){
                tmpSum *= 10;
                k--;
            }
            sum += tmpSum;
        }

        return String.valueOf(sum);
    }
}
