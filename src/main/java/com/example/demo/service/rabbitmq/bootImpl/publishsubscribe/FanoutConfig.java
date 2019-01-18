package com.example.demo.service.rabbitmq.bootImpl.publishsubscribe;

import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {
   /* @Bean
    public FanoutExchange fanout(){
        return new FanoutExchange("andy");
    }*/

    /*

   *//* @Bean(name = "queue1")
    public Queue autoDeleteQueue1(){
        return new AnonymousQueue();
    }

    @Bean(name = "queue2")
    public Queue autoDeleteQueue2(){
        return new AnonymousQueue();
    }

    @Bean(name = "queue3")
    public Queue queue() {
        return new Queue("rpc-queue-zhisheng");
    }

    @Bean
    public Binding binding1(FanoutExchange fanout,
                            @Qualifier("queue1")Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1).to(fanout);
    }

    @Bean
    public Binding binding2(FanoutExchange fanout,
                            @Qualifier("queue2")Queue autoDeleteQueue2) {
        return BindingBuilder.bind(autoDeleteQueue2).to(fanout);
    }

    @Bean
    public Binding binding3(FanoutExchange fanout,
                            @Qualifier("queue3")Queue queue) {
        return BindingBuilder.bind(queue).to(fanout);
    }*//*

    */

   /* @Autowired
    private RabbitProducer producer;

    @PostConstruct
    public void init(){
        for (int i = 0; i < 10; i++) {
            String message = "Liang:" + i;
            System.out.println(" [x] Sent '" + message + "'");
            producer.sendFanout(message);
        }
    }*/
}
