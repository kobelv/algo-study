package com.kobe.tree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 二叉堆
 * 特点：1. 任何根节点要么都比左右子节点小（最小堆），要么都比左右子节点大（最大堆）
 *      2. 二叉堆是完全二叉树，所以存储是用数组，不会浪费空间。
 *      3. 假设父节点的数组下标是parentIndex，则左右子节点的下标是parentIndex*2+1，parentIndex*2+2
 */
public class BinaryHeap {
    public static void downgrade(int[] arr, int parentIndex){
        int childIndex = parentIndex*2+1;
        int tmp = arr[parentIndex];
        //如果存在子节点的话
        while(childIndex < arr.length){
            //判断是否存在右节点，存在的话比较右节点是否比左节点小，如果小的话让父节点下沉到右节点
            if (childIndex+1 < arr.length && arr[childIndex+1]<arr[childIndex]){
                childIndex = childIndex+1;
            }
            //如果父节点比子节点都小，则无需下沉
            if (tmp < arr[childIndex]){
                break;
            }
            //父节点比子节点大，则交换位置，但因为父节点要去到的位置是零时的，暂不赋值
            arr[parentIndex] = arr[childIndex];

            //父节点继续下沉，即比较新位置和它的子节点
            parentIndex = childIndex;
            childIndex = childIndex*2+1;
        }

        arr[parentIndex] = tmp;
    }

    /**
     * 当往二叉堆里插入新数字时，会放入数组的最末尾。需要把末尾数字依次上浮，
     * 使得重新符合二叉堆要求
     * @param arr
     */
    public static void upgrade(int[] arr){
        int needAdjustIndex = arr.length-1; //待调整的位置
        int parentIndex = (needAdjustIndex-1)/2;
        int tmp = arr[needAdjustIndex];

        while(needAdjustIndex > 0 && tmp < arr[parentIndex]){
            arr[needAdjustIndex] = arr[parentIndex];
            needAdjustIndex = parentIndex;
            parentIndex = (needAdjustIndex-1)/2;
        }

        arr[needAdjustIndex] = tmp;

    }

    /**
     * 输入数组是无序的，也就已经是一个无序的二叉树了。构建有序的二叉堆就是把所有非叶子节点
     * 依次下沉
     * @param arr
     * @return
     */
    public static void buildBinaryHeap(int[] arr){
        if(arr == null){
            return ;
        }

        //从最后一个非叶子节点开始做下沉操作
        for (int i=(arr.length-2)/2;i>=0;i--){
            downgrade(arr, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,7,2,5,4,0};
        BinaryHeap.buildBinaryHeap(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {2, 4, 10, 5, 7,0};
        BinaryHeap.upgrade(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
