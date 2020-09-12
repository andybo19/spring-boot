package com.example.demo.threadStudy.pattern.productconsumer;

import com.example.demo.domain.Thread.Apple;

/**
 * @author mayongbo
 * @Description
 * @date 2020/9/12 14:45
 */
public class Consum implements Runnable{

    private Stock stock;

    public Consum(Stock stock){
        this.stock = stock;
    }


    @Override
    public void run() {

        try {
            Apple apple = (Apple) stock.consumer();
            System.out.println("消费Apple="+apple);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
