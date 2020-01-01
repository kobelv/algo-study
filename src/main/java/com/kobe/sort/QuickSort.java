package com.kobe.sort;

public class QuickSort {
    public static void sort(int[] arr, int left, int right) {
        if(arr == null || left >= right){
            return ;
        }
        //经过partition步骤后，arr数组里q位置之前的都是小于q位置上的数字，q位置之后的都大于q位置上的数字
        int q = partition(arr, left, right);
        sort(arr, left, q-1);
        sort(arr, q+1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        //选取right位置上的数作为中间点，把小于它的放左边，大于它的放右边.
        //类似选择排序
        //3,8,6,1,2
        int flag = arr[right];
        int position = left;
        int tmp;
        for (int i=left; i<right; i++){
            if (arr[i] > flag){
                //交换position位置上的数字和i位置上的数字
                tmp = arr[i];
                arr[i] = arr[position];
                arr[position] = tmp;
                position++;
            }
        }
        //此时，从position位置开始的数字都>或者=flag的，因此交换position和right的位置
        tmp = arr[right];
        arr[right] = arr[position];
        arr[position] = tmp;

        return position;
    }

}
