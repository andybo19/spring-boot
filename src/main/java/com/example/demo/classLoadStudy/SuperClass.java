package com.example.demo.classLoadStudy;

/**
 * @author mayongbo
 * @Description
 * @date 2020/4/9 17:32
 */
public class SuperClass extends SSClass {

    static {
        System.out.println("SuperClass init");
    }

    public static int value = 123;

    public static final int b = 456;

    public SuperClass(){
        System.out.println("init SuperClass");
    }
}
