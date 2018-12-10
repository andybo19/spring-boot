package com.example.demo.domain.Thread;

public class ThreadPrintDemo2 {
    public static void main(String[] args) {
        ThreadPrintDemo2 demo2 = new ThreadPrintDemo2();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                demo2.print2();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                demo2.print1();
            }
        });

        thread1.start();
        thread2.start();
    }


    public synchronized void print2() {
        for (int i = 1; i <= 100; i += 2) {
            System.out.println(i);
            this.notify();
            try {
                this.wait();
                Thread.sleep(100);// 防止打印速度过快导致混乱
            } catch (InterruptedException e) {
                // NO
            }
        }
    }

    public synchronized void print1() {
        for (int i = 0; i <= 100; i += 2) {
            System.out.println(i);
            this.notify();
            try {
                this.wait();
                Thread.sleep(100);// 防止打印速度过快导致混乱
            } catch (InterruptedException e) {
                // NO
            }
        }
    }

}
