package com.example.demo.basisStudy;

import java.util.concurrent.TimeUnit;

/**
 * @author mayongbo
 * @Description
 * @date 2021/2/26 15:56
 */
public class VolatileExample {

    private static boolean flag = false;
    private static int i = 0;
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                flag = true;
                System.out.println("flag 被修改成 true");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        while (!flag) {
            i++;
            //System.out.println("一直在累加的i = " + i);
        }
        System.out.println("程序结束,i=" + i);
    }


}
