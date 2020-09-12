package com.example.demo.threadStudy.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author mayongbo
 * @Description
 * @date 2020/4/16 20:33
 */
public class Main {

    public static void main(String[] args) {
        //并行度10000
        int parallel = 2;

        //开始计时
        long a1 = System.currentTimeMillis();

        CountDownLatch signal = new CountDownLatch(1);
        CountDownLatch finish = new CountDownLatch(parallel);

        CalcTest test = new CalcTest();
        test.setI(0);

        for (int i = 1; i <= parallel; i++) {
            ConcurrentThread concurrentThread = new ConcurrentThread(signal, finish, i, test);
            new Thread(concurrentThread).start();
        }

        signal.countDown();
        try {
            finish.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long a2 = System.currentTimeMillis();

        String tip = String.format("RPC调用总共耗时: [%s] 毫秒", a2 - a1);
        System.out.println(test.toString());
        System.out.println(test.getStart().get());
        System.out.println(tip);
    }

}
