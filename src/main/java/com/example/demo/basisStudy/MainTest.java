package com.example.demo.basisStudy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wan yu
 * @date 2021/7/14 上午10:49
 */
public class MainTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        service.submit(() -> System.out.println("Hello "));

        System.out.println("World");
    }
}
