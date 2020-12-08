package com.example.demo.threadStudy.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author mayongbo
 * @Description
 * @date 2020/10/17 20:58
 */
@Slf4j
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete("Hello World Complete");
        String result = completableFuture.get();
        System.out.println("+++++++++++++"+result);
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("运行在一个单独的线程当中");
        });
        future.get();

        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("运行在一个单独的线程当中");
            return "我有返回值";
        });
        System.out.println("--------------------"+supplyAsync.get());

        CompletableFuture<String> comboText = CompletableFuture.supplyAsync(() -> {
            //可以注释掉做快速返回 start
            /*try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }*/
            //log.info("👍");
            //可以注释掉做快速返回 end
            return "赞";
        })
                                                               .thenApply(first -> {
                                                                   log.info("在看");
                                                                   return first + ", 在看";
                                                               })
                                                               .thenApply(second -> second + ", 转发");

        log.info("三连有没有？");
        log.info(comboText.get());

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            log.info("前序操作");
            return "前需操作结果";
        }).thenApplyAsync(res -> {
            log.info("后续操作");
            return "后续操作结果";
        });


    }



    //获取用户信用评级
   /* CompletableFuture<Double> getCreditRating(User user) {
        return CompletableFuture.supplyAsync(() -> CreditRating.builder().rating(7.5).build().getRating());
    }*/

}
