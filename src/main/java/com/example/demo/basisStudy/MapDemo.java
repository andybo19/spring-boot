package com.example.demo.basisStudy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mayongbo
 * @Description
 * @date 2021/3/6 16:31
 */
public class MapDemo {

    public static void main(String[] args) {
        new HashMap<>();
        new ConcurrentHashMap<>();
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        map.put("1",1) ;
        map.put("2",2) ;
        map.put("3",3) ;
        map.put("4",4) ;
        map.put("5",5) ;
        System.out.println(map.toString());
    }

}
