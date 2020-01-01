package com.kobe.sort;

/**
 * 归并排序
 * 1. 时间复杂度：
 *      之最好情况 = O(n*lgn)
 *      之最坏情况 = O(n^2)，因为在原始数字序列已经排序的情况下，partition分区函数的效率就是O(n^2)
 *      之平均情况 = O(n*lgn)，partition分区函数的平均效率是n/2,4/2,8/n,,,
 *      之比较次数 =
 *      之交换次数 =
 * 2. 空间复杂度 = O(n)
 * 3. 空间复杂度之原地排序（是否是O(1)的空间复杂度） = true
 * 4. 排序稳定性（相等的两个值保持排序前的顺序） = false
 *
 *
 */
public class MergeSort {
    public static void sort(int[] arr, int start, int end) {
        if (arr == null || start >= end) {
            return ;
        }

        sort(arr, start, (start + end)/2);
        sort(arr, (start + end)/2 + 1, end);

        merge(arr, start, (start + end)/2, end);
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int leftArraySize = middle-left+1;
        int rightArraySize = right - middle;
        int[] leftArr = new int[leftArraySize + 1];
        int[] rightArr = new int[rightArraySize + 1];
        for (int i=0; i<leftArraySize; i++){
            leftArr[i] = arr[left+i];
        }
        for (int i=0; i<rightArraySize; i++){
            rightArr[i] = arr[middle+1+i];
        }

        //给两个数组分别加入哨兵，为了后续合并数组方便
        leftArr[leftArraySize] = Integer.MAX_VALUE;
        rightArr[rightArraySize] = Integer.MAX_VALUE;

        int i=0, j=0;
        for (int k=left; k<=right;k++){
            if (leftArr[i]>rightArr[j]){
                arr[k] = rightArr[j];
                j++;
            } else {
                arr[k] = leftArr[i];
                i++;
            }
        }

    }

}
