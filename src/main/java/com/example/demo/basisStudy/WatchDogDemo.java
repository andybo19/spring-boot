package com.example.demo.basisStudy;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author mayongbo
 * @Description
 * @date 2021/2/26 19:18
 */
public class WatchDogDemo {

    public static void main(String[] args) {
        System.out.println("开始时间" + new Date());
        watchDog();
        System.out.println("结束时间" + new Date());
    }

    private static void watchDog(){
        HashedWheelTimer timer = new HashedWheelTimer();
        timer.newTimeout(new TimerTask() {

            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("我是看门狗,我每隔3秒就要执行一次! :" + new Date());
            }
        },3, TimeUnit.SECONDS);

        timer.newTimeout(new TimerTask() {

            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("我是看门狗,我每隔3秒就要执行一次! :" + new Date());
            }
        },6, TimeUnit.SECONDS);

        Timeout timeout = timer.newTimeout(new TimerTask() {

            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("我是看门狗,我每隔3秒就要执行一次! :" + new Date());
            }
        }, 9, TimeUnit.SECONDS);
    }

}