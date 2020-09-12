package com.example.demo.threadStudy.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mayongbo
 * @Description
 * @date 2020/9/11 9:39
 */
public class ABC_LOCK {

    private static Lock lock = new ReentrantLock();
    private static int state = 0;

    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    lock.lock();
                    while (state % 3 == 0){
                        System.out.println("++++A");
                        System.out.println("======================="+i);
                        state ++;
                        i++;
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    lock.lock();
                    while (state % 3 == 1){
                        System.out.println("++++B");
                        System.out.println("======================="+i);
                        state ++;
                        i++;
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    lock.lock();
                    while (state % 3 == 2){
                        System.out.println("++++C");
                        System.out.println("======================="+i);
                        state ++;
                        i++;
                    }
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
