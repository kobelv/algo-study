package com.kobe.tree;

import java.util.*;

public class LeetCode199_RightOrLeftSideView {

    public static void main(String[] args) {
        LeetCode199_RightOrLeftSideView r = new LeetCode199_RightOrLeftSideView();
        System.out.println((r.rightSideView(r.buildTree(), true)));

    }

    public List<Integer> rightSideView(TreeNode root, boolean isLeftSide){
        Map<Integer, Integer> rightSideValueWithDepth = new HashMap<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        int maxDepth = 0;

        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();
            maxDepth = Math.max(depth, maxDepth);
            if (!rightSideValueWithDepth.containsKey(depth)){
                rightSideValueWithDepth.put(depth, node.data);
            }

            if (isLeftSide){
                if (node.right != null){
                    nodeStack.push(node.right);
                    depthStack.push(depth+1);
                }

                if (node.left != null){
                    nodeStack.push(node.left);
                    depthStack.push(depth+1);
                }
            } else {
                if (node.left != null){
                    nodeStack.push(node.left);
                    depthStack.push(depth+1);
                }

                if (node.right != null){
                    nodeStack.push(node.right);
                    depthStack.push(depth+1);
                }
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int i=0; i<=maxDepth; i++){
            res.add(rightSideValueWithDepth.get(i));
        }

        return res;
    }

    private TreeNode buildTree(){
        TreeNode root = new TreeNode(1);

        TreeNode tmp = new TreeNode(2);
        root.left = tmp;
        tmp = new TreeNode(3);
        root.right = tmp;

        TreeNode tmp2 = root.right;
        tmp = new TreeNode(5);
        tmp2.right = tmp;

        tmp2 = root.left;

        tmp = new TreeNode(8);
        tmp2.left = tmp;
        tmp = new TreeNode(7);
        tmp2.right = tmp;

        tmp = new TreeNode(6);
        tmp2.right.right = tmp;

        tmp = new TreeNode(9);
        tmp2.left.right = tmp;

        tmp2 =  tmp2.left.right;
        tmp = new TreeNode(10);
        tmp2.left = tmp;
        tmp = new TreeNode(11);
        tmp2.right = tmp;

        return root;
    }
}
