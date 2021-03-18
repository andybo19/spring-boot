package com.example.demo.basisStudy;

/**
 * @author mayongbo
 * @Description
 * @date 2021/3/8 20:02
 */
public class SingletonDemo {

    private SingletonDemo(){

    }

    private static class InnerClassHolder{
        static final SingletonDemo instance = new SingletonDemo();
    }

    public static SingletonDemo getInstance(){
        return InnerClassHolder.instance;
    }



}
