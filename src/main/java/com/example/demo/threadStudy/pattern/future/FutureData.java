package com.example.demo.threadStudy.pattern.future;

/**
 * @author mayongbo
 * @date 2019/11/5 18:49
 */
public class FutureData implements Data {

    private RealData realData;

    private boolean ready =false;

    public synchronized void setRealData(RealData realData){
        if(ready){
            return;
        }
        this.realData=realData;
        this.ready=true;
        System.out.println("Future设置realData当前线程:"+Thread.currentThread().getName());
        notifyAll();
    }

    @Override
    public synchronized  String getContent() {
        while (!ready){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Future获取内容当前线程:"+Thread.currentThread().getName());
        return realData.getContent();
    }
}
