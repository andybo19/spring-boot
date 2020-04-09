package com.example.demo.threadStudy.pattern.threadLocal;

/**
 * @author mayongbo
 * @date 2019/11/8 15:52
 */
public class Main {

    public static void main(String[] args) {
        new ClientThread("Alice").start();
        new ClientThread("Bobby").start();
        new ClientThread("Chris").start();
    }
}
