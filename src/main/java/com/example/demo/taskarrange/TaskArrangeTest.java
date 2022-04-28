package com.example.demo.taskarrange;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author wan yu
 * @date 2021/11/12 下午7:04
 */
public class TaskArrangeTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        Future future = executor.submit(new Task());
        //这一步get会阻塞当前线程
        System.out.println(future.get());

        executor.shutdown();
    }
}
