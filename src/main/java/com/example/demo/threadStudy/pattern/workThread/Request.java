package com.example.demo.threadStudy.pattern.workThread;

import java.util.Random;

/**
 * @author mayongbo
 * @date 2019/11/4 19:35
 */
public class Request {

    private final String name;

    private final int number;

    private static final Random random = new Random();

    public Request(String name,int number){
        this.name=name;
        this.number=number;
    }

    public void execute(){
        System.out.println(Thread.currentThread().getName()+" executes "+ this);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String toString(){
        return "[ Request from "+name+" ,NO."+number+" ]";
    }
}
