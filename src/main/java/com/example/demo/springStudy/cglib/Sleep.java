package com.example.demo.springStudy.cglib;

/**
 * @author mayongbo
 * @date 2020/1/4 15:03
 */
public class Sleep {

    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
