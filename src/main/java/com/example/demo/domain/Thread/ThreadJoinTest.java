package com.example.demo.domain.Thread;

public class ThreadJoinTest extends Thread {
    public ThreadJoinTest(String name){
        super(name);
        System.out.println("构造方法---开始");
        System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()="+Thread.currentThread().isAlive());
        System.out.println("this.getName()="+this.getName());
        System.out.println("this.isAlive()="+this.isAlive());
        System.out.println("构造方法---结束");
    }
    @Override
    public void run(){
        System.out.println(this.getName());
        System.out.println(this.isAlive());
        System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()="+Thread.currentThread().isAlive());
        for(int i=0;i<100;i++){
            System.out.println(this.getName() + ":" + i);
        }
    }
}
