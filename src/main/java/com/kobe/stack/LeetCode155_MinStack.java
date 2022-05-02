package com.kobe.stack;

import java.util.Stack;

public class LeetCode155_MinStack {
    public static void main(String[] args) {
        LeetCode155_MinStack s = new LeetCode155_MinStack();
        s.push(4);
        s.push(9);
        s.push(-2);
        s.push(0);
        s.push(-3);
        System.out.println(s.getMin());
        s.pop();
        s.top();
        System.out.println(s.getMin());
    }

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public LeetCode155_MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int val) {
        if (minStack.isEmpty()){
            minStack.push(val);
        } else if (val < minStack.peek()){
            minStack.push(val);
        }

        stack.push(val);
    }

    public void pop() {
        if(top() == minStack.peek()){
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.pop();
    }
}
