package com.kobe.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 */
public class LeetCode94_InOrder {
    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        TreeNode tmp = new TreeNode(2);
        r.right = tmp;
        tmp = new TreeNode(3);
        r.right.left = tmp;
        System.out.println(new LeetCode94_InOrder().inorderTraversal(r));

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    public void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null){
            return;
        }

        if (root.left != null){
            inorderTraversal(root.left, result);
        }
        result.add(root.data);

        if (root.right != null){
            inorderTraversal(root.right, result);
        }
    }
}
