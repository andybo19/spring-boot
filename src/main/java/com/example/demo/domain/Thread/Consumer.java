package com.example.demo.domain.Thread;

import java.util.concurrent.LinkedBlockingQueue;

public class Consumer  implements Runnable{
    private final LinkedBlockingQueue<Apple> queue;

    Consumer(LinkedBlockingQueue<Apple> queue){
        this.queue = queue;
    }


    @Override
    public void run() {
        //synchronized (queue){
            try {
                Apple apple = null;
                apple = queue.take();
                System.out.println("消费Apple="+apple);
            } catch (Exception e) {
                e.printStackTrace();
            }
       // }

    }

   /* private final List<Apple> queue;

    Consumer(List<Apple> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        synchronized (queue){
            try {
                while (queue.size() == 0){
                    queue.wait();
                }
                Apple apple = null;
                apple = queue.remove(0);
                //Thread.sleep(100);
                System.out.println("消费Apple="+apple);
                queue.notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }*/


}
