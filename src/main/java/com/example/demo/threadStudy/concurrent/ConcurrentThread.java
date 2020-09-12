package com.example.demo.threadStudy.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author mayongbo
 * @Description
 * @date 2020/4/16 19:50
 */
public class ConcurrentThread implements Runnable {

    private CountDownLatch signal;

    private CountDownLatch finish;

    private CalcTest test;

    private int taskNumber = 0;

    public ConcurrentThread(CountDownLatch signal,CountDownLatch finish,int taskNumber, CalcTest test){
        this.signal = signal;
        this.finish = finish;
        this.taskNumber = taskNumber;
        this.test = test;
    }

    @Override
    public void run() {
        try {
            signal.await();
            System.out.println("+++++++++++++++taskNumber:"+taskNumber);
            //test.addNum(taskNumber);
            test.addAtomic(taskNumber);
            finish.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
