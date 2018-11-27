package com.example.demo.domain.Thread;

public class ThreadTest implements Runnable {

    int number =10;

    public void firstMethod(){
        synchronized (this){
            number += 100;
            System.out.println(number);
        }
    }

    public void secondMethod(){
        synchronized (this){
            try {
                Thread.sleep(2000);
                //this.wait(2000);
                number *=200;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void run() {
        firstMethod();
    }


    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        Thread thread = new Thread(threadTest);
        thread.start();
        threadTest.secondMethod();
        System.out.println("number="+threadTest.number);
    }
}
