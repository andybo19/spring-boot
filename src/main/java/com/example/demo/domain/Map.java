package com.example.demo.domain;

import java.util.HashMap;

public class Map {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(2);
        map.put("one",1);
        Integer one = map.get("one");
        System.out.println(one);
    }
}
