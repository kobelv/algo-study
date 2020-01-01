package com.kobe.stack;

import java.util.Stack;

/*
 * 设计一个栈，可以查询栈中最小值
 * */
public class StackWithGetMin {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;
	
	public StackWithGetMin() {
		this.stack = new Stack<>();
		this.minStack = new Stack<>();
	}
	public int getMin(){
		if(minStack.isEmpty()){
			throw new RuntimeException("empty stack");
		}
		return minStack.peek();
	}
	public int pop(){
		if(stack.isEmpty()){
			throw new RuntimeException("empty stack");
		}
		if(stack.peek() == minStack.peek()){
			minStack.pop();
		}
		return stack.pop();
	}
	public void push(int value){
		stack.push(value);
		
		if(minStack.isEmpty()){
			minStack.push(value);
		} else {
			if(value < minStack.peek()){
				minStack.push(value);
			}
		}
	}
	
	public static void main(String[] args) {
		StackWithGetMin s = new StackWithGetMin();
		s.push(3);
		s.push(2);
		s.push(5);
		s.push(1);
		s.push(4);
		System.out.println("Current min value is: " + s.getMin());
		System.out.println("Pop value is: " + s.pop());
		System.out.println("Current min value is: " + s.getMin());
		System.out.println("Pop value is: " + s.pop());
		System.out.println("Current min value is: " + s.getMin());
		System.out.println("Pop value is: " + s.pop());
		System.out.println("Current min value is: " + s.getMin());
		System.out.println("Pop value is: " + s.pop());
		System.out.println("Current min value is: " + s.getMin());
		System.out.println("Pop value is: " + s.pop());
		System.out.println("Current min value is: " + s.getMin());
		System.out.println("Pop value is: " + s.pop());
		System.out.println("Current min value is: " + s.getMin());
	}

}
