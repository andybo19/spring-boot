package com.example.demo.domain.Thread;


import java.util.concurrent.LinkedBlockingQueue;

public class ArrayBlockingQueueDemo {
    private final static LinkedBlockingQueue<Apple> queue= new LinkedBlockingQueue<>(2);
    //private final static List<Apple> queue= new ArrayList<>(1);
    public static void main(String[] args) {
       /* new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();*/

        for (int i =0;i<5;i++){
            new Thread(new Producer(queue)).start();
            new Thread(new Consumer(queue)).start();
        }

    }
}
