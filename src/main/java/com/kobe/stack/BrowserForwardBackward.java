package com.kobe.stack;

import java.util.Stack;

/**
 *用两个栈模拟浏览器前进后退行为
 * 1. 初始化一个状态
 * 2. 前进时如果toBeBrowserStack还有页面，则从toBeBrowserStack出栈并压栈browseredStack
 * 2. 后退时如果browseredStack还有页面，则从browseredStack出栈并压栈toBeBrowserStack
 */

public class BrowserForwardBackward {

    Stack<String> browseredStack = new Stack<>();
    Stack<String> toBeBrowserStack = new Stack<>();

    public void init(String[] strarr){
        if (strarr == null){
            return;
        }

        for (int i = 0; i<strarr.length;i++){
            browseredStack.push(strarr[i]);
        }
    }
    public void forward(){
        if (!toBeBrowserStack.empty()){
            browseredStack.push(toBeBrowserStack.pop());
        } else {
            System.out.println("no more page to forward");
        }
    }

    public void backward(){
        if (!browseredStack.empty()){
            toBeBrowserStack.push(browseredStack.pop());
        } else {
            System.out.println("no more page to backward");
        }
    }

    public void printStatus(){

    }
    public static void main(String[] args) {
        BrowserForwardBackward browser = new BrowserForwardBackward();
        browser.init(new String[]{"a", "b","c","d"});
        browser.forward();
        browser.backward();
        browser.backward();
        browser.forward();
    }

}
