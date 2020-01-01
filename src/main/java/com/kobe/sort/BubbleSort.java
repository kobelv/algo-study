package com.kobe.sort;

/**
 * 冒泡排序
 * 1. 时间复杂度：
 *      之最好情况 =
 *      之最坏情况 = O(n^2)
 *      之比较次数 =
 *      之交换次数 =
 * 2. 空间复杂度 =
 * 3. 空间复杂度之原地排序（是否是O(1)的空间复杂度） =
 * 4. 排序稳定性（相等的两个值保持排序前的顺序） =
 *
 *
 */
public class BubbleSort {

    public static void sort(int[] arr){
        if (arr == null){
            return;
        }

        int tmp;
        for(int i=0; i<arr.length;i++){
            for (int j=i+1; j<arr.length;j++){
                if (arr[i] > arr[j]){
                    //交换位置
                    tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i]=tmp;
                }
            }
        }

    }


}
