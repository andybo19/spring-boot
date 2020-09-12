package com.example.demo.threadStudy.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mayongbo
 * @Description
 * @date 2020/9/12 8:44
 */
public class ABC_LOCK_CONDITION {

    private static final ReentrantLock lock = new ReentrantLock();

    private static Condition conditionA = lock.newCondition();

    private static Condition conditionB = lock.newCondition();

    private static Condition conditionC = lock.newCondition();

    private static int count = 0;

    static class ThreadA extends Thread {

        @Override
        public void run() {
                for (int i = 0; i < 10; i++) {
            try {
                lock.lock();
                        while (count % 3 != 0){
                            conditionA.await();
                        }
                        System.out.println("++++++++++++A");
                        count++;
                        conditionB.signal();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
                }
        }
    }

    static class ThreadB extends Thread {

        @Override
        public void run() {
                for (int i = 0; i < 10; i++) {
            try {
                lock.lock();
                    while (count % 3 != 1){
                        conditionB.await();
                    }
                    System.out.println("++++++++++++B");
                    count++;
                    conditionC.signal();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
                }
        }
    }

    static class ThreadC extends Thread {

        @Override
        public void run() {
                for (int i = 0; i < 10; i++) {
            try {
                lock.lock();
                    while (count % 3 != 2){
                        conditionC.await();
                    }
                    System.out.println("++++++++++++C");
                    count++;
                    conditionA.signal();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
                }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }

}
