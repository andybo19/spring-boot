package com.example.demo.service.rabbitmq.basejavaImpl;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class RabbitReceive {
    private final static String QUEUE_NAME = "hello_durable1";

    public static void main(String[] args) {
        // 创建连接
        ConnectionFactory factory = new ConnectionFactory();
        // 设置 RabbitMQ 的主机名
        factory.setHost("192.168.1.203");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("123456abc");


        Connection connection = null;
        try {
            // 创建一个连接
            connection = factory.newConnection();

             // 创建一个通道
            Channel channel = connection.createChannel();
            // 指定一个队列
            // queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
            // 参数1 queue ：队列名
            // 参数2 durable ：是否持久化
            // 参数3 exclusive ：仅创建者可以使用的私有队列，断开后自动删除
            // 参数4 autoDelete : 当所有消费客户端连接断开后，是否自动删除队列
            // 参数5 arguments
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
           /* // 创建队列消费者
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" [x] Received '" + message + "'");
                }
            };
            // basicConsume(String queue, boolean autoAck, Consumer callback)
            // 参数1 queue ：队列名
            // 参数2 autoAck ： 是否自动ACK
            // 参数3 callback ： 消费者对象的一个接口，用来配置回调
            channel.basicConsume(QUEUE_NAME, true, consumer);*/
            channel.basicQos(1);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
                try {
                    doWork(message);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(" [x] Done");
                    channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                }
            };
            boolean autoAck = false;
            channel.basicConsume(QUEUE_NAME, autoAck, deliverCallback, consumerTag -> { });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void doWork(String task) throws InterruptedException {
        String[] taskArr = task.split(":");
        Thread.sleep(3000);
    }
}
