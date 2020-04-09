package com.example.demo.classLoadStudy;

/**
 * @author mayongbo
 * @Description
 * @date 2020/4/9 18:00
 */
public class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init");
    }

    public static int a;

    public SubClass(){
        System.out.println("init SubClass");
    }
}
