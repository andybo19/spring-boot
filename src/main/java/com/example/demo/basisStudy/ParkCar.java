package com.example.demo.basisStudy;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author mayongbo
 * @Description
 * @date 2021/2/19 17:11
 */
public class ParkCar implements Runnable{

    private int n;
    private String carName;
    private Semaphore semaphore;

    public ParkCar(int n, String carName, Semaphore semaphore) {
        this.n = n;
        this.carName = carName;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            if (semaphore.availablePermits() < n) {
                System.out.println(Thread.currentThread().getName() + "来停车,但是停车位不够了,等着吧");
            }
            semaphore.acquire(n);
            System.out.println(Thread.currentThread().getName() + "把自己的" + carName + "停进来了,剩余停车位:" + semaphore.availablePermits() + "辆");
            //模拟停车时长
            int parkTime = ThreadLocalRandom.current().nextInt(1, 6);
            TimeUnit.SECONDS.sleep(parkTime);
            System.out.println(Thread.currentThread().getName() + "把自己的" + carName + "开走了,停了" + parkTime + "小时");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release(n);
            System.out.println(Thread.currentThread().getName() + "走后,剩余停车位:" + semaphore.availablePermits() + "辆");
        }
    }

}
