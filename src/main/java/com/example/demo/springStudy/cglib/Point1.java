package com.example.demo.springStudy.cglib;

/**
 * @author mayongbo
 * @date 2020/1/4 15:02
 */
public class Point1 implements Chain.Point {

    @Override
    public Object proceed(Chain chain) {
        System.out.println("point 1 before");
        Sleep.sleep(20);
        Object result = chain.proceed();
        Sleep.sleep(20);
        System.out.println("point 1 after");
        return result;
    }
}
