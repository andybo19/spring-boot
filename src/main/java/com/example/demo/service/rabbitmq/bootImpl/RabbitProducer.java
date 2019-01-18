package com.example.demo.service.rabbitmq.bootImpl;

import com.example.demo.service.rabbitmq.bootImpl.helloworld.RabbitConfig;
import com.example.demo.service.rabbitmq.bootImpl.workqueue.WorkQueue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

   /* @Autowired
    private FanoutExchange fanoutExchange;*/

    /**
     * 最基本的helloworld 示例
     * @param message
     */
    public void send(String message){
        rabbitTemplate.convertAndSend(RabbitConfig.queue,message);
    }

    /**
     * 最基本的workqueue 示例
     * @param message
     */
    public void sendWork(String message){
        rabbitTemplate.convertAndSend(WorkQueue.workQueue,message);
    }

    /**
     * 最基本的fanout 示例
     * @param message
     */
    public void sendFanout(String message){
        rabbitTemplate.convertAndSend("qin","",message);
    }

    /**
     * 最基本的direct 示例
     * @param message
     */
    public void send(String exchange,String message,String routeKey){
        rabbitTemplate.convertAndSend(exchange,routeKey,message);
    }




}
