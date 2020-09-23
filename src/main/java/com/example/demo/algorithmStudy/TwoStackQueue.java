package com.example.demo.algorithmStudy;

import java.util.Stack;

/**
 * @author mayongbo
 * @Description
 * @date 2020/9/17 21:53
 */
public class TwoStackQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
