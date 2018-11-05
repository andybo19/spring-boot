package com.example.demo.domain;

public class Thread1 implements Runnable {

    private int num = 50;

    @Override
    public void run() {

            for (int i = 0; i < 50; i++) {
                synchronized (this) {
                    if (num > 0) {
                        try {
                            Thread.sleep(10);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " synchronized loop " + num);
                        num--;
                    }
                }
            }

    }

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread ta = new Thread(t1, "A");
        Thread tb = new Thread(t1, "B");
        ta.start();
        tb.start();
    }
}
