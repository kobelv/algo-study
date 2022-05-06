package com.kobe.tree;

public class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	TreeNode(){}
	TreeNode(int data){
		this.data = data;
	}
    TreeNode(int val, TreeNode left, TreeNode right) {
          this.data = val;
          this.left = left;
          this.right = right;
      }
}
