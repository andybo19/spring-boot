package com.example.demo.algorithmStudy;

import java.util.Stack;

/**
 * @author mayongbo
 * @Description
 * @date 2021/3/15 19:41
 */
public class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(outStack.isEmpty()){
            inToOut();
        }
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(outStack.isEmpty()){
            inToOut();
        }
        Integer peek = outStack.peek();
        return peek;

    }

    private void inToOut() {
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }


}
