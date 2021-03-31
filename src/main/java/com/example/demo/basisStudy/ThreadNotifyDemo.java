package com.example.demo.basisStudy;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mayongbo
 * @Description
 * @date 2021/3/31 9:42
 */
public class ThreadNotifyDemo {

    private static ReentrantLock lock = new ReentrantLock();


    private static Condition conditionA = lock.newCondition();

    private static Condition conditionB = lock.newCondition();

    private static Condition conditionC = lock.newCondition();

    private static int state =0;

    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5;i++) {
                try {
                    lock.lock();
                    while (state % 3 != 0) {// 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                        conditionA.await();
                    }
                    for(int j = 0;j < 5;j++){
                        System.out.print("A");
                    }
                    ++state;
                    conditionB.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();// unlock()操作必须放在finally块中
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5;i++) {
                try {
                    lock.lock();
                    while (state % 3 != 1) {// 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                        conditionB.await();
                    }
                    for(int j = 0;j < 10;j++) {
                        System.out.print("B");
                    }
                    ++state;
                    conditionC.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();// unlock()操作必须放在finally块中
                }
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5;i++) {
                try {
                    lock.lock();
                    while (state % 3 != 2) {// 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                        conditionC.await();
                    }
                    for(int j = 0;j < 15;j++){
                        System.out.print("C");
                    }
                    ++state;
                    conditionA.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();// unlock()操作必须放在finally块中
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
/*        Thread threadA = new Thread(() ->{
            //for(int i = 0; i < 10;){
                lock.lock();
                try {
                    System.out.println("线程A进入");
                    while (state % 4 == 0){
                        System.out.println("A");
                        ++state;
                        //++i;
                    }
                    System.out.println("线程A退出");
                }finally {
                    lock.unlock();
                }
            //}

        });
        Thread threadB = new Thread(() ->{
            //for(int i = 0; i < 10;){
                lock.lock();
                try {
                    System.out.println("线程B进入");
                    while (state % 4 == 1){
                        System.out.println("B");
                        ++state;
                //        ++i;
                    }
                    System.out.println("线程B退出");
                }finally {
                    lock.unlock();
                }
           // }
        });
        Thread threadC = new Thread(() ->{
            //for(int i = 0; i < 10;){
                lock.lock();
                try {
                    System.out.println("线程C进入");
                    while (state % 4 == 2){
                        System.out.println("C");
                        ++state;
                //        ++i;
                    }
                    System.out.println("线程C退出");
                }finally {
                    lock.unlock();
                }
           // }
        });
        Thread threadD = new Thread(() ->{
           // for(int i = 0; i < 10;){
                lock.lock();
                try {
                    System.out.println("线程D进入");
                    while (state % 4 == 3){
                        System.out.println("D");
                        ++state;
              //          ++i;
                    }
                    System.out.println("线程D退出");
                }finally {
                    lock.unlock();
                }
           // }
        });
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();*/

        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();




    }



}
