package com.example.demo.basisStudy;

/**
 * @author wan yu
 * @date 2021/7/14 上午10:48
 */
public class SonHello implements ParentHello{
    @Override
    public String sayHello(String name) {
        return "Hi, " + name;
    }
}
