package com.example.demo.threadStudy.pattern.workThread;

/**
 * @author mayongbo
 * @date 2019/11/4 19:31
 */
public class WorkThread extends Thread {

    private final Channel channel;

    public WorkThread(String name,Channel channel){
        super(name);
        this.channel =channel;
    }

    public void run(){
        while (true){
            Request request = channel.takeRequest();
            request.execute();
        }
    }


}
