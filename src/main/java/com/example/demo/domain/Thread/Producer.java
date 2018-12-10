package com.example.demo.domain.Thread;

import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable {

    private final LinkedBlockingQueue<Apple> queue;

    Producer(LinkedBlockingQueue<Apple> queue){
        this.queue = queue;
    }


    @Override
    public void run() {
        //synchronized (queue){
            try {
                Apple apple = new Apple();
                queue.put(apple);
                //Thread.sleep(100);
                System.out.println("生产:"+apple);
            } catch (Exception e) {
                e.printStackTrace();
            }
       // }

    }

   /* private final List<Apple> queue;

    Producer(List<Apple> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        synchronized (queue){
            try {
                while (queue.size() > 0){
                    queue.wait();
                }
                Apple apple = new Apple();
                queue.add(apple);
                //Thread.sleep(100);
                System.out.println("生产:"+apple);
                queue.notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }*/
}
