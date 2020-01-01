package com.kobe.stack;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Stack;

/**
 * 表达式求值
 * 1. 用两个栈保存状态，numStack保存数字，operatorStack一个保存操作符
 * 2. 从左到右遍历表达式，遇到数字则压栈numStack，遇到操作符，则
 * 2.1 如果是‘(’，直接入栈
 * 2.2 如果是‘)’，依次出栈计算，直到栈顶是‘(’
 * 2.3 如果是其他操作符，和比较operatorStack的栈顶操作符比较优先级。
 *    如果当前操作符号优先级更高，则压栈operatorStack
 *    否则就从操作符栈出栈，并且计算
 *
 *    计算逻辑：
 *    从numStack出栈两个数字，从operatorStack出栈操作符，进行计算，计算结果再次压栈numStack
 */
public class ExpressionCalc {
    public Stack<BigDecimal> numStack;
    public Stack<String> operatorStack;
    public String expr;
    public HashMap<String, Integer> priority;
    public ExpressionCalc(){
        this.numStack = new Stack<>();
        this.operatorStack = new Stack<>();
        priority = new HashMap<>(10);
        initPriority();
    }

    public ExpressionCalc(String expr){
        this.numStack = new Stack<>();
        this.operatorStack = new Stack<>();
        this.expr = expr;
        priority = new HashMap<>(10);
        initPriority();
    }
    public void initPriority(){
        priority.put("(", 0);
        priority.put(")", 0);
        priority.put("+", 1);
        priority.put("-", 1);
        priority.put("*", 2);
        priority.put("/", 2);
    }

    public BigDecimal calc(){
        int count = 0;
        boolean isNum = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<expr.length(); i++){
            if ((expr.charAt(i)>='0' && expr.charAt(i)<='9')
                || expr.charAt(i) == '.'){
                sb.append(expr.charAt(i));
                isNum = true;
                count++;
                continue;
            }

            if (isNum){
                numStack.push(new BigDecimal(sb.toString()));
                sb.delete(0, count);
                isNum = false;
                count = 0;
            }

            if (operatorStack.isEmpty()){
                operatorStack.push(String.valueOf(expr.charAt(i)));
                continue;
            }

            if (expr.charAt(i) == '('){
                operatorStack.push(String.valueOf(expr.charAt(i)));
                continue;
            }

            if (!operatorStack.empty() &&
                    priority.get(String.valueOf(expr.charAt(i)))>priority.get(operatorStack.peek())){
                operatorStack.push(String.valueOf(expr.charAt(i)));
            } else if (expr.charAt(i) == ')'){
                while (!operatorStack.peek().equals("(")){
                    calcInternal();
                }
                operatorStack.pop();

            } else {
                calcInternal();
                operatorStack.push(String.valueOf(expr.charAt(i)));
            }

        }

        if (isNum){
            numStack.push(new BigDecimal(sb.toString()));
        }
        calcInternal();
        return numStack.pop();
    }

    private void calcInternal() {
        BigDecimal num1 = numStack.pop();
        BigDecimal num2 = numStack.pop();
        switch (operatorStack.pop()){
            case "+":
                numStack.push(num1.add(num2));
                break;
            case "-":
                numStack.push(num1.subtract(num2));
                break;
            case "*":
                numStack.push(num1.multiply(num2));
                break;
            case "/":
                numStack.push(num1.divide(num2));
                break;
        }
    }

    public static void main(String[] args) {
        String expr = "10+(2.2*(2.5*1+4.5*1)+4)+5.7";
        ExpressionCalc calculator = new ExpressionCalc(expr);
        System.out.println(calculator.calc());
    }

}
