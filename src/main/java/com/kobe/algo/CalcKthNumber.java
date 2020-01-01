package com.kobe.algo;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 */
public class CalcKthNumber {

    /**
     * 求中位数也是求第k大的数的一种特列
     * 1. 因为是两个数组，所以比较两个数组的第k/2大小，小的那个数组的前面k/2都是可以排除的。
     * 2. k=k-排除的数字个数
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1 == null ? 0 : nums1.length;
        int length2 = nums2 == null ? 0 : nums2.length;
        //如果总个数是奇数，则最中间那个就是(left==right)
        //如果总个数是偶数，则是中间两个(left、right)的平均值
        int left = (length1 + length2 + 1) / 2;
        int right = (length1 + length2 + 2) / 2;

        return (getKth(nums1, 0, length1-1, nums2, 0, length2-1, left)
                + getKth(nums1, 0, length1-1, nums2, 0, length2-1, right)) / 2.0;
    }

    public static double getKth(int[] num1, int start1, int end1,
                    int[] num2, int start2, int end2, int k){
        int length1 = end1-start1+1;
        int length2 = end2-start2+1;

        if (length1 == 0){
            return num2[start2+k-1];
        } else if (length2 == 0){
            return num1[start1+k-1];
        }

        if (k == 1){
            return Math.min(num1[start1], num2[start2]);
        }

        //选择两个数组的考察位置
        int index1 = start1 + Math.min(length1, k/2) -1;
        int index2 = start2 + Math.min(length2, k/2) -1;
        if(num1[index1] >= num2[index2]){
            //排除num2中 index2前面的数字，同时k减小
            return getKth(num1, start1, end1, num2, index2+1, end2, k-(index2-start2+1));
        } else{
            //排除num1中 index1前面的数字，同时k减小
            return getKth(num1, index1+1, end1, num2, start2, end2, k-(index1-start1+1));

        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1,3};
        int[] arr2 = {2,4,8,9,10,11};
        System.out.println(CalcKthNumber.findMedianSortedArrays(arr1, arr2));
    }
}
