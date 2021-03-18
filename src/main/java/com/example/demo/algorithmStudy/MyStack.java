package com.example.demo.algorithmStudy;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author mayongbo
 * @Description
 * @date 2021/3/15 20:02
 */
public class MyStack {

    Queue<Integer> queue;

    Queue<Integer> backQueue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedBlockingDeque<>();
        backQueue = new LinkedBlockingDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        masterToSalve(queue.size() - 1, backQueue, queue);
        Integer last = queue.poll();
        masterToSalve(backQueue.size(), queue, backQueue);
        return last;

    }

    /** Get the top element. */
    public int top() {
        masterToSalve(queue.size() - 1, backQueue, queue);
        Integer last = queue.poll();
        backQueue.add(last);
        masterToSalve(backQueue.size(), queue, backQueue);
        return last;
    }

    private void masterToSalve(int size, Queue<Integer> backQueue, Queue<Integer> queue) {
        for (int i = 0; i < size; i++) {
            backQueue.add(queue.poll());
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
