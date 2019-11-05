package com.example.demo.threadStudy.pattern.ThreadPerMessage;

/**
 * @author mayongbo
 * @date 2019/11/4 19:19
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("main BEGIN");
        Host host = new Host();
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');
        System.out.println("main END");
    }

}
