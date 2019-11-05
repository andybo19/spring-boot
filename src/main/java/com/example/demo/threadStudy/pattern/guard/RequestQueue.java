package com.example.demo.threadStudy.pattern.guard;

import java.util.LinkedList;

/**
 * @author mayongbo
 * @date 2019/10/29 16:52
 */
public class RequestQueue {

    private final LinkedList<Request> queue = new LinkedList<>();

    public synchronized Request getRequest(){
        while(queue.size() <=0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.removeFirst();
    }

    public synchronized void putRequest(Request request){
        queue.addLast(request);
        notifyAll();
    }

}
