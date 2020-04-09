package com.example.demo.springStudy.cglib;

/**
 * @author mayongbo
 * @date 2020/1/4 15:16
 */
public class Test {

    public static void main(String[] args) {
        Object proxy = ProxyFactory.create().getProxy(new SayHello());
        proxy.toString();
    }

    static class SayHello{

        @Override
        public String toString(){
            return "hello cglib !";
        }
    }

}
