package com.example.demo.threadStudy.threadConcept;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mayongbo
 * @date 2019/10/29 10:52
 */
public class MyThread /*extends Thread*/ implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i+" name:"+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        /*Thread thread = new Thread(new MyThread());
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(i+" name:"+Thread.currentThread().getName());
        }*/
        ArrayList<Object> list = new ArrayList<>();
        List<Object> subList = list.subList(0, 0);

    }

}
