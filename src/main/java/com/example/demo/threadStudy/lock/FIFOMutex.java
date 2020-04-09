package com.example.demo.threadStudy.lock;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * @author mayongbo
 * @date 2020/1/2 14:23
 */
public class FIFOMutex {

    private final AtomicBoolean locked = new AtomicBoolean(false);
    private final Queue<Thread> waiters = new ConcurrentLinkedDeque<Thread>();

    public void lock(){
        Thread current = Thread.currentThread();
        waiters.add(current);

        while (waiters.peek() != current || !locked.compareAndSet(false,true)){
            LockSupport.park(this);
        }
        waiters.remove();
    }

    public void unlock(){
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }
}
