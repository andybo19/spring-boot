package com.example.demo.domain.Thread;

import java.util.concurrent.locks.LockSupport;

public class LockSupportInterruptDemo {
    static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");


    static class ChangeObjectThread extends Thread {

        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            System.out.println("begin " + getName());
            synchronized (u) {
                System.out.println("in " + getName());
                // wait
                LockSupport.park();
                if (Thread.interrupted()) {
                    System.err.println(getName() + "被中断了");
                }
            }
            System.out.println(getName() + "执行结束了");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始线程名字"+Thread.currentThread().getName());
        t1.start();
        Thread.sleep(1000);
        System.out.println("中间线程名字"+Thread.currentThread().getName());
        t2.start();
        Thread.sleep(3000);

        //t1.interrupt();
        // notify
        //LockSupport.unpark(t1);
        System.out.println("后来线程名字"+Thread.currentThread().getName());
        LockSupport.unpark(t2);
        System.out.println("最后线程名字"+Thread.currentThread().getName());
        Thread thread = Thread.currentThread();
        /*System.out.println("开始线程名字"+thread.getName());
        LockSupport.park();// 获取许可
        System.out.println("许可释放没");
        System.out.println("b");
        LockSupport.unpark(thread);//释放许可*/
        System.out.println("结束线程名字"+thread.getName());
    }

}
