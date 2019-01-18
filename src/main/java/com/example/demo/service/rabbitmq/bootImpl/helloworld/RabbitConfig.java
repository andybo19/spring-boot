package com.example.demo.service.rabbitmq.bootImpl.helloworld;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String queue = "helloworld";

    /*@Bean
    public Queue queue(){
        return  new Queue(queue);
    }*/
}
