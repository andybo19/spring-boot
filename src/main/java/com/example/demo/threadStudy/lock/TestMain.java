package com.example.demo.threadStudy.lock;

/**
 * @author mayongbo
 * @Description
 * @date 2020/8/28 22:39
 */
public class TestMain {

    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0 ;i<100000;i++){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }).start();
        System.out.println("main 执行完了");
    }

}
