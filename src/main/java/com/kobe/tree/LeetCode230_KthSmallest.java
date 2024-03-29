package com.kobe.tree;

import java.util.ArrayList;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 *
 */
public class LeetCode230_KthSmallest {
    public static void main(String[] args) {
        int[] arr = {4,2,6,1};
        LeetCode230_KthSmallest l = new LeetCode230_KthSmallest();
        System.out.println(l.kthSmallest(TreeUtil.createBinaryTreeByArray(arr), 2));
    }

    public int kthSmallest(TreeNode root, int k){
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for (int i=0; i<list.size(); i++){
            if (i == k-1){
                return list.get(i);
            }
        }
        return -1;
    }

    public void inOrder(TreeNode root, ArrayList<Integer> list){
        if (root == null){
            return;
        }

        inOrder(root.left, list);

        list.add(root.data);

        inOrder(root.right, list);
    }
}
