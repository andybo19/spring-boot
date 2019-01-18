package com.example.demo.service.rabbitmq.basejavaImpl;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class RabbitSend {

    private final static String QUEUE_NAME = "hello_durable1";

    public static void main(String[] args) {
        // 创建连接
        ConnectionFactory factory = new ConnectionFactory();
        // 设置 RabbitMQ 的主机名
        factory.setHost("192.168.1.203");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("123456abc");
        try {
            // 创建一个连接
            Connection connection = factory.newConnection();
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
            // 发送消息
            // basicPublish(String exchange, String routingKey, BasicProperties props, byte[] body)
            // 参数1 exchange ：交换器
            // 参数2 routingKey ： 路由键
            // 参数3 props ： 消息的其他参数
            // 参数4 body ： 消息体
            // 发送消息
            for (int i = 0; i < 10; i++) {
                String message = "Liang:" + i;
                channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
                System.out.println(" [x] Sent '" + message + "'");
            }
            // 关闭频道和连接
            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
