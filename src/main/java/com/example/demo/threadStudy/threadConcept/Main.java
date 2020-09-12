package com.example.demo.threadStudy.threadConcept;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author mayongbo
 * @date 2019/11/10 16:41
 */
@Slf4j
public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // 使用 Callable ，可以获取返回值
        Callable<String> callable = () -> {
            log.info("进入 Callable 的 call 方法");
            // 模拟子线程任务，在此睡眠 2s，
            // 小细节：由于 call 方法会抛出 Exception，这里不用像使用 Runnable 的run 方法那样 try/catch 了
            Thread.sleep(5000);
            return "Hello from Callable";
        };

        log.info("提交 Callable 到线程池");
        Future<String> future = executorService.submit(callable);

        log.info("主线程继续执行");

        log.info("主线程等待获取 Future 结果");
        long startTime =  System.nanoTime();
        while(!future.isDone()) {
            log.info("Task is still not done...");
            Thread.sleep(1000);
            double elapsedTimeInSec = (System.nanoTime() - startTime)/1000000000.0;

            // 如果程序运行时间大于 1s，则取消子线程的运行
            if(elapsedTimeInSec > 1) {
                future.cancel(true);
            }
        }
        // Future.get() blocks until the result is available
        if (!future.isCancelled()){
            log.info("子线程任务已完成");
            String result = future.get();
            log.info("主线程获取到 Future 结果: {}", result);
        }else {
            log.warn("子线程任务被取消");
        }

        executorService.shutdown();


    }

}
