package com.example.demo.threadStudy.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mayongbo
 * @Description
 * @date 2020/4/16 20:20
 */
public class CalcTest {

    private Integer total;

    private AtomicInteger start = new AtomicInteger(0);

    public void addNum(Integer num){
        this.total += num;
    }

    public Integer getI() {
        return total;
    }

    public void setI(Integer i) {
        this.total = i;
    }

    public void addAtomic(Integer num){
        start.getAndAdd(num);
    }

    @Override
    public String toString() {
        return "CalcTest{" +
                "total=" + total +
                '}';
    }

    public AtomicInteger getStart() {
        return start;
    }

    public void setStart(AtomicInteger start) {
        this.start = start;
    }
}
