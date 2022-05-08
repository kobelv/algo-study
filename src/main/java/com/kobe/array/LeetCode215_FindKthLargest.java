package com.kobe.array;

import java.util.Random;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 */
public class LeetCode215_FindKthLargest {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        new LeetCode215_FindKthLargest().findKthLargest(arr, 3);
    }

    public int findKthLargest(int[] nums, int k) {

        quickSort(nums, 0, nums.length -1);

        return -1;
    }

    private void quickSort(int[] nums, int left, int right){
        if (left > right){
            return;
        }

        int randomV = new Random().nextInt(nums.length);
        int flag = nums[randomV];
        while (left < right){
            while (nums[right] >= flag && left < right){
                right --;
            }
            while (nums[left] <= flag && left < right){
                left ++;
            }
            if (left < right){
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                right --;
            }
        }

        nums[randomV] = nums[right];
        nums[right] = flag;

        quickSort(nums, 0, right - 1);
        quickSort(nums, right + 1, nums.length -1);
    }
}
