package com.example.demo.threadStudy.pattern.twoPhase;

/**
 * @author mayongbo
 * @date 2019/11/5 20:21
 */
public class CountupThread extends Thread {

    private Long counter =0L;
    private volatile boolean shutdownRequested = false;

    public void shutdownRequest(){
        System.out.println("shutdown线程:"+Thread.currentThread().getName());
        shutdownRequested = true;
        interrupted();
    }

    public boolean isShutdownRequested(){
        return shutdownRequested;
    }

    @Override
    public void run() {
        try {
            while (!isShutdownRequested()){
                doWork();
            }
        }catch (Exception e){
            System.out.println("异常信息"+e.getMessage());
        }finally {
            doShutdown();
        }

    }

    private void doWork() throws InterruptedException {
        counter++;
        System.out.println("doWork: counter= "+counter);
        System.out.println("doWork线程:"+Thread.currentThread().getName());
        Thread.sleep(500);
    }

    private void doShutdown(){
        System.out.println("doShutdown: counter= "+counter);
        System.out.println("doShutdown线程:"+Thread.currentThread().getName());
    }
}
