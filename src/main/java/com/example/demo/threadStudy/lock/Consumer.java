package com.example.demo.threadStudy.lock;

import com.example.demo.threadStudy.pattern.workThread.Request;

/**
 * @author mayongbo
 * @date 2020/1/6 16:19
 */
public class Consumer extends Thread{

    private String name;
    private BoundedBuffer buffer;

    public Consumer(BoundedBuffer buffer, String name) {
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {
        Request request = null;
        try {
            request = (Request) buffer.take();
            System.out.println(name+"消费了"+request);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
