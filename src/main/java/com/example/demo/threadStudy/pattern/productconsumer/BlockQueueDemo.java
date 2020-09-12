package com.example.demo.threadStudy.pattern.productconsumer;

import com.example.demo.domain.Thread.Apple;

/**
 * @author mayongbo
 * @Description
 * @date 2020/9/12 14:51
 */
public class BlockQueueDemo {

    public static void main(String[] args) {
        Stock<Apple> stock = new Stock<Apple>(5);
        for (int i =0;i<5;i++){
            new Thread(new Product(stock)).start();
            new Thread(new Consum(stock)).start();
        }
    }

}
