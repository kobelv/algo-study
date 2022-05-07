package com.kobe.tree;


import java.util.*;

public class TreeUtil {
		
	public static TreeNode createBinaryTreeByArray(int[] array){
		if(array == null || array.length == 0){
			return null;
		}
		
		List<TreeNode> nodeList = new LinkedList<TreeNode>();	       
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new TreeNode(array[nodeIndex]));
        }
       
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
            nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
        }
      
        int lastParentIndex = array.length / 2 - 1;
      
        nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 + 1);	       
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex * 2 + 2);
        }	    
	
        return nodeList.get(0);
	}

	public static TreeNode createBinaryTreeByList(LinkedList<Integer> inputList){
		if(inputList == null || inputList.isEmpty()){
			return null;
		}

		Integer data = inputList.removeFirst();
		TreeNode treeNode = null;
		if (data != null){
			treeNode = new TreeNode(data);
			treeNode.left = createBinaryTreeByList(inputList);
			treeNode.right = createBinaryTreeByList(inputList);
		}
		return treeNode;
	}

	public static void preOrderTravel(TreeNode root){
		if(root == null){
			return;
		}
		
		System.out.print(root.data + "---");
		preOrderTravel(root.left);
		preOrderTravel(root.right);
	}
	
	public static void postOrderTravel(TreeNode root){
		if(root == null){
			return;
		}
		
		postOrderTravel(root.left);
		postOrderTravel(root.right);
		System.out.print(root.data + "---");
	}
	
	public static void inOrderTravel(TreeNode root){
		if(root == null){
			return;
		}
		
		inOrderTravel(root.left);
		System.out.print(root.data + "---");
		inOrderTravel(root.right);
	}

	/**
	 * 深度优先遍历 - 非递归实现
	 *
	 * 算法思想：
	 * 利用栈来保存中间状态
	 * @param root
	 */
	public static void dfs(TreeNode root){
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();	   
	    nodeStack.add(root);
	    while(!nodeStack.isEmpty()){
	    	TreeNode n = nodeStack.pop();
	    	System.out.print(n.data + "---");
	    	if(n.right != null){
	    		nodeStack.push(n.right);
	    	}
	    	if(n.left != null){
	    		nodeStack.push(n.left);
	    	}	    	
	    }	    
	}

	/**
	 * 广度优先遍历
	 *
	 * 算法思想：
	 * 利用队列保存中间状态
	 * @param root
	 */
	public static void bfs(TreeNode root){
		Deque<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();	   
	    nodeQueue.add(root);
	    while(!nodeQueue.isEmpty()){
	    	TreeNode n = nodeQueue.pop();
	    	System.out.print(n.data + "---");
	    	
	    	if(n.left != null){
	    		nodeQueue.add(n.left);
	    	}	    	
	    	if(n.right != null){
	    		nodeQueue.add(n.right);
	    	}
	    }	    
	}
	
	public static void main(String[] args){
		int[] inputArray = {1, 2, 3, 4, 5};
		//TreeNode root = util.createBinaryTreeByArray(inputArray);
		/*util.preOrderTravel(root);
		util.inOrderTravel(root);
		util.postOrderTravel(root);*/
		//util.bfs(root);
		//util.inOrder(root);
		LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(
				new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
		TreeNode node = TreeUtil.createBinaryTreeByList(inputList);
		TreeUtil.bfs(node);
		//TreeUtil.preOrderTravel(node);
	}
	
}
