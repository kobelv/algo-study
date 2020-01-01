package com.kobe.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CalcAveragePerLevel {
	/*Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
			Example 1:
			Input:
			    3
			   / \
			  9  20
			    /  \
			   15   7
			Output: [3, 14.5, 11]
			Explanation:
			The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
			Note:
			The range of node's value is in the range of 32-bit signed integer.
*/

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> result = new ArrayList<>();
		List<TreeNode> queue = new LinkedList<>();		
		queue.add(root);
		while(!queue.isEmpty()){
			long count = 0;
			long sum = 0;
			List<TreeNode> tmpQueue = new LinkedList<>(); 
			while(!queue.isEmpty()){
				TreeNode x = queue.remove(0);
				sum += x.data;
				count ++;
				
				if(x.left != null){
					tmpQueue.add(x.left);
				}
				if(x.right != null){
					tmpQueue.add(x.right);
				}			
			}
			
			queue = tmpQueue;			
			result.add(sum * 1.0 /count);
		}		
		
        return result;
    }

	public static void main(String[] args){
		int[] arr = {1, 2, 3, 4, 5};
		TreeNode root = TreeUtil.createBinaryTreeByArray(arr);
		CalcAveragePerLevel calc = new CalcAveragePerLevel();
		System.out.println(calc.averageOfLevels(root).toString());
		
	}
	

}
