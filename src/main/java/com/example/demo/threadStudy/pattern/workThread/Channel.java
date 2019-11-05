package com.example.demo.threadStudy.pattern.workThread;

/**
 * @author mayongbo
 * @date 2019/11/4 19:24
 */
public class Channel {
    private static final int MAX_REQUEST =100;//最大请求数
    private final Request[] requestQueue;//请求队列
    private int head;
    private int tail;
    private int count;
    private final WorkThread[] threadPool;

    public Channel(int threads){
        requestQueue = new Request[MAX_REQUEST];
        this.head=0;
        this.tail=0;
        this.count=0;

        threadPool = new WorkThread[threads];
        for (int i=0;i<threadPool.length;i++) {
            threadPool[i]=new WorkThread("Worker-" + i, this);
        }
    }
    
    public void startWorkers(){
        for (int i=0;i<threadPool.length;i++) {
            threadPool[i].start();
        }
    }

    public synchronized void putRequest(Request request){
        while (count > requestQueue.length){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        requestQueue[tail] =request;
        tail =(tail +1) % requestQueue.length;
        count++;
        notifyAll();
    }

    public synchronized Request takeRequest(){
        while (count <=0 ){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Request request = requestQueue[head];
        head =(head + 1)% requestQueue.length;
        count--;
        notifyAll();
        return request;
    }

}
