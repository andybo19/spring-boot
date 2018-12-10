package com.example.demo.domain.Thread;

public class SingleDouble {

    static volatile int num = 0;

    static volatile boolean flag = false;

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;num<100;){
                    if(!flag &&(num == 0 || ++num % 2 ==0)){
                        System.out.println(num);
                        flag = true;
                    }
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;num<100;){
                    if(flag &&(++num % 2 !=0)){
                        System.out.println(num);
                        flag = false;
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }


}
