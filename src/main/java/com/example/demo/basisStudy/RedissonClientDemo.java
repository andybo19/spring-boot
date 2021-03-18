package com.example.demo.basisStudy;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * @author mayongbo
 * @Description
 * @date 2021/2/26 16:53
 */
public class RedissonClientDemo {

    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");

        RedissonClient redissonClient = Redisson.create(config);

        RLock rLock = redissonClient.getLock("andy");
        rLock.lock();
        //业务代码
        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        rLock.unlock();
    }

}
