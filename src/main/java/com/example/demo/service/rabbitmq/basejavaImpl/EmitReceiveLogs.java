package com.example.demo.service.rabbitmq.basejavaImpl;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.util.Random;

public class EmitReceiveLogs {
    private final static String EXCHANGE_NAME = "direct_logs";
    private static final String[] LOG_LEVEL_ARR = {"debug", "info", "error"};

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
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");
            // 设置日志级别
            int rand = new Random().nextInt(3);
            String severity  = LOG_LEVEL_ARR[rand];
            String queueName = channel.queueDeclare().getQueue();
            channel.queueBind(queueName, EXCHANGE_NAME, severity);

            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
            System.out.println(" [*] Log level "+severity);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            };
            channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
