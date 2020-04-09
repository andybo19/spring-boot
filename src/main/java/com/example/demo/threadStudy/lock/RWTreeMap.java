package com.example.demo.threadStudy.lock;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author mayongbo
 * @date 2019/12/31 20:06
 */
public class RWTreeMap {

    private final Map<String,Object> m = new TreeMap<String,Object>();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    public Object get(String key){
        r.lock();
        try {
            return m.get(key);
        }finally {
            r.unlock();
        }
    }

    public String[] allKeys(){
        r.lock();
        try {
            return (String[]) m.keySet().toArray();
        }finally {
            r.unlock();
        }
    }

    public Object put(String key,Object value){
        w.lock();
        try {
            return m.put(key,value);
        }finally {
            w.unlock();
        }
    }

    public void clear(){
        w.lock();
        try {
            m.clear();
        }finally {
            w.unlock();
        }
    }

}
