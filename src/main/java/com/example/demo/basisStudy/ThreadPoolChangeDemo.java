package com.example.demo.basisStudy;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author mayongbo
 * @Description
 * @date 2021/3/1 10:50
 */
public class ThreadPoolChangeDemo {

    public static void main(String[] args) throws InterruptedException {
        dynamicModifyExecutor();
    }

    private static ThreadPoolExecutor buildThreadPoolExecutor(){
        return new ThreadPoolExecutor(2,
                5,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(20),
                new NamedThreadFactory("安迪"));
    }

    private static void dynamicModifyExecutor() throws InterruptedException {
        ThreadPoolExecutor executor = buildThreadPoolExecutor();
        for (int i = 0; i < 25 ; i++){
            executor.submit(() ->{
                threadPoolStatus(executor,"创建任务");
                try {
                    TimeUnit.SECONDS.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPoolStatus(executor,"改变之前");
        TimeUnit.SECONDS.sleep(5);
        executor.setCorePoolSize(10);
        executor.setMaximumPoolSize(10);
        executor.prestartCoreThread();
        threadPoolStatus(executor,"改变之后");
        Thread.currentThread().join();
    }

    private static void threadPoolStatus(ThreadPoolExecutor executor, String name){
        LinkedBlockingQueue queue = (LinkedBlockingQueue) executor.getQueue();
        System.out.println(Thread.currentThread().getName() + "-" + name + "-:" +
                "核心线程数:" + executor.getCorePoolSize() +
                " 活动线程数:" + executor.getActiveCount() +
                " 最大线程数:" + executor.getMaximumPoolSize() +
                " 线程池活跃度:" +
                        divide(executor.getActiveCount(),executor.getMaximumPoolSize()) +
                " 任务完成数:" + executor.getCompletedTaskCount() +
                " 队列大小:" + (queue.size() + queue.remainingCapacity()) +
                " 当前排队线程数:" + queue.size() +
                " 队列剩余大小:" + queue.remainingCapacity() +
                " 队列使用度:" + divide(queue.size(),queue.size() + queue.remainingCapacity())
                );
    }

    private static String divide(int num1, int num2){
        return String.format("%1.2f%%",(num1 * 1.0) / (num2 * 1.0) * 100);
    }

}
