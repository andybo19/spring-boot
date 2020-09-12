package com.example.demo.threadStudy.pattern.productconsumer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mayongbo
 * @Description
 * @date 2020/9/12 9:26
 */
public class Stock<T> {

    private static final ReentrantLock lock = new ReentrantLock();

    private static Condition not_full = lock.newCondition();

    private static Condition not_empty = lock.newCondition();

    private Queue<T> queue = new ArrayDeque<>();

    private int length;

    public Stock(int length){
        this.length = length;
    }

    public void product(T t){
        try {
            lock.lock();
            while (queue.size() == length){
                not_full.await();
            }
            queue.add(t);
            not_empty.signal();;
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public T consumer(){
        T poll = null;
        try {
            lock.lock();
            while (queue.size() == 0){
                not_empty.await();
            }
            not_full.signal();
            poll = queue.poll();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return poll;
    }


}
