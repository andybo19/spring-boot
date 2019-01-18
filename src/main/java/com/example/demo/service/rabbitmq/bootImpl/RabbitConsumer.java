package com.example.demo.service.rabbitmq.bootImpl;

public class RabbitConsumer {
/*
    @RabbitListener(queues = RabbitConfig.queue)
    public void receive(String message){
        System.out.println(RabbitConfig.queue+" 队列接收的消息"+message);
    }

    @RabbitListener(queues = WorkQueue.workQueue)
    public void receiveWork(String message){
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(WorkQueue.workQueue+" 队列接收的消息"+message);
    }

    @RabbitListener(queues = "#{queue1.name}")
    public void receive1(String in) throws InterruptedException {
        receive(in, 1);
    }

    @RabbitListener(queues = "#{queue2.name}")
    public void receive2(String in) throws InterruptedException {
        receive(in, 2);
    }

    @RabbitListener(queues = "rpc-queue-zhisheng")
    public void receive3(String in) throws InterruptedException {
        receive(in, 3);
    }

    public void receive(String in, int receiver) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println("instance " + receiver + " [x] Received '" + in + "'");
        doWork(in);
        watch.stop();
        System.out.println("instance " + receiver + " [x] Done in "
                + watch.getTotalTimeSeconds() + "s");
    }

    private void doWork(String in) throws InterruptedException {
                Thread.sleep(1000);
    }*/

}
