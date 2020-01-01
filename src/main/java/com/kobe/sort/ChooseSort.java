package com.kobe.sort;
/**
 * 插入排序
 * 0. 算法思路
 * - 从左到右遍历，把当前遍历节点的左边看做已排序区域，右边看做待排序区域。
 * - 从当前节点遍历直到数组，找出比当前节点比，最小的那个节点， 然后跟当前节点交换
 *
 * 1. 时间复杂度：
 *      之最好情况 = O(n)
 *      之最坏情况 = O(n^2)
 *      之比较次数 =
 *      之交换次数 =
 * 2. 空间复杂度 = O(1)
 * 3. 空间复杂度之原地排序（是否是O(1)的空间复杂度） = true
 * 4. 排序稳定性（相等的两个值保持排序前的顺序） = false
 *
 *
 */
public class ChooseSort {
    public static void sort(int[] arr) {
        if (arr == null) {
            return;
        }

        int min, position = -1, tmp;
        boolean needSwitch = false;
        for(int i=0; i<arr.length; i++){
            min = arr[i];
            int j=i+1;
            needSwitch = false;
            for(; j<arr.length; j++){
                if (arr[j]<min){
                    needSwitch = true;
                    min = arr[j];
                    position = j;
                }
            }
            if (needSwitch){
                tmp = arr[position];
                arr[position] = arr[i];
                arr[i]=tmp;
            }
        }
    }
}
