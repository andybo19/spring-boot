package com.example.demo.taskarrange;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author wan yu
 * @date 2021/11/12 下午8:54
 */
@Slf4j
public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       /* CompletableFuture<String> completableFuture = new CompletableFuture<String>();
        completableFuture.complete("Future's Result Here Manually");
        String result = completableFuture.get();
        System.out.println("result: " + result);*/

 /*       CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("运行在一个单独的线程当中");
        });

        future.get();*/

        /*CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            log.info("运行在一个单独的线程当中");
            return "我有返回值";
        });

        log.info(future.get());*/


        /*CompletableFuture<String> comboText = CompletableFuture.supplyAsync(() -> {
            //可以注释掉做快速返回 start
       *//*     try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            log.info("👍");*//*
            //可以注释掉做快速返回 end
            return "赞";
        })
                .thenApply(first -> {
                    log.info("在看");
                    return first + ", 在看";
                })
                .thenApply(second -> second + ", 转发");

        log.info("三连有没有？");
        log.info("结果: "+comboText.get());*/



        CompletableFuture.supplyAsync(() -> {
            log.info(Thread.currentThread().getName() + "-女神：我开始化妆了，好了我叫你。");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "化妆完毕了。";
        }).whenComplete((returnStr, exception) -> {
            if (exception == null) {
                log.info(Thread.currentThread().getName() + returnStr);
            } else {
                log.info(Thread.currentThread().getName() + "女神放你鸽子了。");
                exception.printStackTrace();
            }
        });
        log.info(Thread.currentThread().getName() + "-等女神化妆的时候可以干点自己的事情。");
        Thread.currentThread().join();

    }
}
