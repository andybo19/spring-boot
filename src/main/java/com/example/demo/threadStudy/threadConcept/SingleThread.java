package com.example.demo.threadStudy.threadConcept;

/**
 * @author mayongbo
 * @date 2019/10/29 10:46
 */
public class SingleThread extends Thread {

    public static void main(String[] args) {
        /*for (int i=0;i<10;i++){
            System.out.println(i+" name:"+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);    //当前main线程暂停1000ms
            } catch (InterruptedException e) {
            }
        }*/
        new SingleThread().start();
        new SingleThread().start();
    }



    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + MySystem.getInstance().getDate());
    }

}
