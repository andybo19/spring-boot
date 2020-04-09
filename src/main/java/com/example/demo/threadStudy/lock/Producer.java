package com.example.demo.threadStudy.lock;

import com.example.demo.threadStudy.pattern.workThread.Request;

/**
 * @author mayongbo
 * @date 2020/1/6 15:26
 */
public class Producer extends Thread {

    private String name;
    private BoundedBuffer buffer;

    public Producer(BoundedBuffer buffer, String name) {
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            Request request = new Request(name, i);
            try {
                buffer.put(request);
                System.out.println(name+"生产了"+request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
