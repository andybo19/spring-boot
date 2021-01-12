package com.example.demo.proxy;

/**
 * @author mayongbo
 * @Description
 * @date 2021/1/12 15:15
 */
public class CountServiceImpl implements CountService {

    private int count = 0;

    @Override
    public int count() {
        return count ++;
    }
}
