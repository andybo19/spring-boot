package com.example.demo.taskarrange;

import java.util.concurrent.Callable;

/**
 * @author wan yu
 * @date 2021/11/12 下午7:05
 */
public class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(2000);
        return 1;
    }
}
