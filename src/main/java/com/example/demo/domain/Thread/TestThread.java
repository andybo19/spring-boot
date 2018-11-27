package com.example.demo.domain.Thread;

public class TestThread extends Thread{
    @Override
    public void run() {
        System.out.println(this.getName());
        System.out.println(this.isAlive());
        System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()="+Thread.currentThread().isAlive());
    }

}
