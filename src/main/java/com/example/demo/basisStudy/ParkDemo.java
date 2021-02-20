package com.example.demo.basisStudy;

import java.util.concurrent.Semaphore;

/**
 * @author mayongbo
 * @Description
 * @date 2021/2/19 17:04
 */
public class ParkDemo {

    public static void main(String[] args) {

        Integer parkSpace = 3;
        System.out.println("这里有" + parkSpace + "个停车位,先到先得啊！");
        Semaphore semaphore = new Semaphore(parkSpace, true);

        Thread threadA = new Thread(new ParkCar(1, "布加迪", semaphore), "赵四");
        Thread threadB = new Thread(new ParkCar(2, "法拉利", semaphore), "刘能、谢广坤");
        Thread threadC = new Thread(new ParkCar(1, "劳斯莱斯", semaphore), "why哥");

        threadA.start();
        threadB.start();
        threadC.start();

    }


}
