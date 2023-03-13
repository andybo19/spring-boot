package com.example.demo.designpatterns.template;

/**
 * @author wan yu
 * @date 2023/2/8 下午8:32
 */
public class Keeper {

    public void feed(Animal a) {
        System.out.println("Animal feed");
        a.eat();
    }

    public void feed(Dog dog) {
        System.out.println("dog feed");
        dog.eat();
    }
}
