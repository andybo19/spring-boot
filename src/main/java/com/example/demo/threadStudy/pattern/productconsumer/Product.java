package com.example.demo.threadStudy.pattern.productconsumer;

import com.example.demo.domain.Thread.Apple;

/**
 * @author mayongbo
 * @Description
 * @date 2020/9/12 9:44
 */
public class Product implements Runnable{

    private Stock stock;

    public Product(Stock stock){
        this.stock = stock;
    }


    @Override
    public void run() {
        try {
            Apple apple = new Apple();
            stock.product(apple);
            //Thread.sleep(100);
            System.out.println("生产:"+apple);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
