package com.example.demo.domain;

public class EasyTest {
    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader(ClassLoader.getSystemClassLoader().getParent());
        try {
            Class<? extends Object> testClass = myClassLoader.loadClass("com.example.demo.domain.User");
            Object obj = testClass.newInstance();
            System.out.println("加载器为"+obj.getClass().getClassLoader().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("++++++++++++++++++++++++");
    }
}
