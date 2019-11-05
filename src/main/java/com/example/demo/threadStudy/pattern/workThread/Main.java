package com.example.demo.threadStudy.pattern.workThread;

/**
 * @author mayongbo
 * @date 2019/11/4 20:00
 */
public class Main {

    public static void main(String[] args) {
        Channel channel = new Channel(5);
        channel.startWorkers();
        new ClientThread("andy",channel).start();
        new ClientThread("qin",channel).start();
        new ClientThread("Alice",channel).start();

    }
}
