package com.kobe.algo;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 */
public class LeetCode66_AddOne_E {


    public static void main(String[] args){
        int[] num = {1,3,2,9};
        //print - before
        printArr(num);

        //print - after
        printArr(addOne(num));
    }

    private static int[] addOne(int[] input){
        for(int j=input.length-1; j>0; j--){
            if(j == input.length-1){
                input[j] +=1;
            }

            if(input[j] >9){
                input[j] = input[j]%10;
                input[j-1] += 1;
            }
        }

        if(input[0] >9){
            int[] output = new int[input.length+1];
            output[0] = 1;
            input[0] %= 10;
            for (int i=0; i<input.length;i++){
                output[i+1] = input[i];
            }
            return output;
        }

        return input;
    }

    private static void printArr(int[] arr){
        for (int i=0; i<arr.length;i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }

}
