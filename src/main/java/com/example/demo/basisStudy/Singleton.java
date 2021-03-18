package com.example.demo.basisStudy;

/**
 * @author mayongbo
 * @Description
 * @date 2021/3/8 14:32
 */
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if (singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        for(int i =0;i< 10; i++){
            int finalI = i;
            Runnable runnable = new Runnable() {

                @Override
                public void run() {
                    System.out.println("线程: "+ finalI + "--" + Singleton.getInstance());
                }
            };
            new Thread((runnable)).start();
        }
    }

}
