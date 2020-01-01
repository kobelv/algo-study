package com.kobe.search;

import com.kobe.sort.QuickSort;

/**
 * 求第K大的数
 * 算法思想：
 * - 利用快速排序的分区函数方法，每次把数组分成left~q-1，q，q+1~right
 * - 如果K = q+1，则q位置上的数就是第K大的数，否则就继续在q的左边或者q的右边递归查找
 */
public class SearchKthNumber {
    public static int K = 3;
    public static int searchKth(int[] arr, int left, int right) {
        //经过partition步骤后，arr数组里q位置之前的都是小于q位置上的数字，q位置之后的都大于q位置上的数字
        int q = QuickSort.partition(arr, left, right);
        if(q+1 == K){
            return arr[q];
        } else if (q+1 < K){
            return searchKth(arr, q+1, right);
        } else {
            return searchKth(arr, left, q-1);
        }

    }
}
