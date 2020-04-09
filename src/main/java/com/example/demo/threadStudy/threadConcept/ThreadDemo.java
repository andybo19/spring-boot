package com.example.demo.threadStudy.threadConcept;

/**
 * @author mayongbo
 * @date 2019/11/10 16:40
 */
public class ThreadDemo  extends  Thread{

    @Override
    public void run() {
        System.out.println("线程名称:"+Thread.currentThread().getName());
        try {
            //Thread.sleep(100);
            testBlock();
            System.out.println("执行完了");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void testBlock(){
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
