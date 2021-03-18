package com.example.demo.basisStudy;

/**
 * @author mayongbo
 * @Description
 * @date 2021/3/17 11:08
 */
public class ThreadDemo {

    public static volatile int race = 0;

    public static void main(String[] args) {
        for(int i = 0; i < 5; i++){
            System.out.println("ThreadDemo start..." + i);
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println("race = " + race);

    }

    public  static Thread[] findAllThread(){
        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        while (currentGroup.getParent()!=null){
            // 返回此线程组的父线程组
            currentGroup=currentGroup.getParent();
        }
        //此线程组中活动线程的估计数
        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];
        //把对此线程组中的所有活动子组的引用复制到指定数组中。
        currentGroup.enumerate(lstThreads);

        for (Thread thread : lstThreads) {
            System.out.println("线程数量："+noThreads+" " +
                    "线程id：" + thread.getId() +
                    " 线程名称：" + thread.getName() +
                    " 线程状态：" + thread.getState() +
                    " 线程是否为守护线程：" + thread.isDaemon());
        }
        return lstThreads;
    }

}
