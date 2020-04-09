package com.example.demo.service.rabbitmq.bootImpl;

//@Service
public class RabbitProducer {

   /* @Autowired
    private RabbitTemplate rabbitTemplate;

   *//* @Autowired
    private FanoutExchange fanoutExchange;*//*

    *//**
     * 最基本的helloworld 示例
     * @param message
     *//*
    public void send(String message){
        rabbitTemplate.convertAndSend(RabbitConfig.queue,message);
    }

    *//**
     * 最基本的workqueue 示例
     * @param message
     *//*
    public void sendWork(String message){
        rabbitTemplate.convertAndSend(WorkQueue.workQueue,message);
    }

    *//**
     * 最基本的fanout 示例
     * @param message
     *//*
    public void sendFanout(String message){
        rabbitTemplate.convertAndSend("qin","",message);
    }

    *//**
     * 最基本的direct 示例
     * @param message
     *//*
    public void send(String exchange,String message,String routeKey){
        rabbitTemplate.convertAndSend(exchange,routeKey,message);
    }
*/



}
