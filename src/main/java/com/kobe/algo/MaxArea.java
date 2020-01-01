package com.kobe.algo;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 输入: [1,8,6,2,5,4,8,3,7]
 输出: 49
 */
public class MaxArea {

    //O(n^2)
    public static int maxArea1(int[] height) {
        if(height == null || height.length<2){
            return 0;
        }
        int maxV = 0;
        for(int i=0; i<height.length; i++){
            for(int j=i+1; j<height.length; j++){
                int tmp = height[i]<height[j] ? height[i] : height[j];
                if(tmp*(j-i) > maxV){
                    maxV = tmp*(j-i);
                }
            }
        }
        return maxV;
    }

    //O(n)
    public static int maxArea2(int[] height) {
        if(height == null || height.length<2){
            return 0;
        }
        int maxV = 0, tmp;
        for(int i=0, j=height.length-1; i<j;){
            if (height[i]<=height[j]){
                tmp = height[i]*(j-i);
                i++;
            } else{
                tmp = height[j]*(j-i);
                j--;
            }

            if(tmp > maxV){
                maxV = tmp;
            }
        }
        return maxV;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(MaxArea.maxArea1(arr));
        System.out.println(MaxArea.maxArea2(arr));
    }
}
