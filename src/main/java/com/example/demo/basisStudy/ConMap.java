package com.example.demo.basisStudy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mayongbo
 * @Description
 * @date 2021/2/19 19:56
 */
public class ConMap {

    public static void main(String[] args) {
        System.out.println("方法开始");
        Map<String, Integer> map = new ConcurrentHashMap<>(16);
        map.computeIfAbsent(
                "AaAa",
                key -> {
                    return map.computeIfAbsent(
                            "BBBB",
                            key2 -> 42);
                }
        );
        System.out.println("方法结束 map = "+map);
    }

}
