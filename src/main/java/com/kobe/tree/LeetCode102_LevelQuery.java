package com.kobe.tree;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class LeetCode102_LevelQuery {
    public static void main(String[] args) throws InterruptedException {
        TreeNode root = new TreeNode(3);

        TreeNode tmp = new TreeNode(9);
        root.left = tmp;

        tmp = new TreeNode(20);
        root.right = tmp;

        tmp = new TreeNode(15);
        root.right.left = tmp;

        tmp = new TreeNode(7);
        root.right.right = tmp;


        levelOrder(root);

    }

    public static List<List<Integer>> levelOrder(TreeNode root) throws InterruptedException {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode p = null;
        while (!queue.isEmpty()){
            List<Integer> l = new ArrayList<>();
            int size = queue.size();
            for (int i=0; i<size; i++){
                p = queue.poll();
                l.add(p.data);
                if (p.left != null){
                    queue.offer(p.left);
                }
                if (p.right != null){
                    queue.offer(p.right);
                }
            }
            ans.add(l);
        }
       return ans;
    }
}
