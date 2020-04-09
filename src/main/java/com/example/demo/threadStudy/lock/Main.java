package com.example.demo.threadStudy.lock;

/**
 * @author mayongbo
 * @date 2020/1/2 15:42
 */
public class Main {

    public static void main(String[] args) {
        FIFOMutex mutex = new FIFOMutex();
        MyThread a1 = new MyThread("a1", mutex);
        MyThread a2 = new MyThread("a2", mutex);
        MyThread a3 = new MyThread("a3", mutex);

        a1.start();
        a2.start();
        a3.start();

        try {
            a1.join();
            a2.join();
            a3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assert MyThread.count == 300;
        System.out.println("Finished");

    }

}

class MyThread extends Thread {

    private String name;
    private FIFOMutex mutex;
    public static int count;

    public MyThread(String name, FIFOMutex mutex) {
        this.name = name;
        this.mutex = mutex;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            mutex.lock();
            count++;
            System.out.println("name:" + name + "  count:" + count);
            mutex.unlock();
        }
    }
}