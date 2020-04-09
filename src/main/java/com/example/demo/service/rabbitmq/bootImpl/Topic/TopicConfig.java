package com.example.demo.service.rabbitmq.bootImpl.Topic;

//@Configuration
public class TopicConfig {
    private static final String[] LOG_LEVEL_ARR = {"dao.error.debug", "dao.info", "dao.error",
            "try.service.debug", "service.info", "service.error",
            "controller.debug", "controller.info", "controller.error"};

    /*@Autowired
    private RabbitProducer producer;

    @Autowired
    private Environment environment;

    @PostConstruct
    public void init(){
        for (String severity : LOG_LEVEL_ARR) {
            String message = "Liang-MSG log : [" +severity+ "]" + UUID.randomUUID().toString();
            System.out.println(" [x] Sent '" + message + "'");
            producer.send("topic",message,severity);
        }
    }*/

}
