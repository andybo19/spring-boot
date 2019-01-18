package com.example.demo.service.rabbitmq.bootImpl.route;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig {
    private static final String[] routeKeys = {"error","info","warn"};

   /* @Autowired
    private RabbitProducer producer;

    @PostConstruct
    public void init(){
        for (int i = 0; i < 10; i++) {
            int rand = new Random().nextInt(3);
            String routeKey = routeKeys[rand];
            String message = "Liang-MSG log : [" +routeKey+ "]"+ UUID.randomUUID().toString();
            System.out.println(" [x] Sent '" + message + "'");
            producer.sendDirect(message,routeKey);
        }
    }*/


}
