package com.example.demo.threadStudy.lock;

/**
 * @author mayongbo
 * @date 2020/1/6 15:25
 */
public class TestDemo {

    public static void main(String[] args) {
        BoundedBuffer buffer = new BoundedBuffer();
        Producer producer = new Producer(buffer, "生产者");
        Consumer consumer1 = new Consumer(buffer, "消费者1");
        Consumer consumer2 = new Consumer(buffer, "消费者2");
        consumer1.start();
        consumer2.start();
        producer.start();

    }

}
