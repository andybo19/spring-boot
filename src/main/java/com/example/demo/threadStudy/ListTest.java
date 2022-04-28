package com.example.demo.threadStudy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wan yu
 * @date 2022/1/4 上午11:08
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        list.add("ee");
        list.add("ff");
        list.add("gg");

        Thread thread1 = new Thread(() -> {
            for (String str : list) {
                System.out.println(str);
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            list.add("HH");
            list.add("KK");
        });
        thread2.start();



    }
}
