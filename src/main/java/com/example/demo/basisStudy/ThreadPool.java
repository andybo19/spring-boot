package com.example.demo.basisStudy;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * @author mayongbo
 * @Description
 * @date 2021/2/22 17:10
 */
public class ThreadPool {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolTaskExecutor executor = buildThreadPoolExecutor();
        executor.execute(() -> sayHello("execute"));

        TimeUnit.MILLISECONDS.sleep(10);
        System.out.println("=================================");
        Future<?> submit = executor.submit(() -> sayHello("submit"));
        try {
            submit.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        ExecutorService threadPool = Executors.newFixedThreadPool(10);
    }

    private static void sayHello(String name){
        String logStr = "[thread name:" + Thread.currentThread().getName() + ",执行方式:" + name+"]";
        System.out.println(logStr);
        throw new RuntimeException(logStr + ",我异常啦!哈哈哈!");
    }

    private static ThreadPoolTaskExecutor buildThreadPoolExecutor(){
        ThreadPoolTaskExecutor poolExecutor = new ThreadPoolTaskExecutor();
        poolExecutor.setThreadNamePrefix("安迪学习多线程");
        poolExecutor.setCorePoolSize(5);
        poolExecutor.setMaxPoolSize(10);
        poolExecutor.setQueueCapacity(1000);
        poolExecutor.setKeepAliveSeconds(30);
        poolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        poolExecutor.initialize();
        return poolExecutor;
    }
}
