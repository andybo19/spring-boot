package com.example.demo.service.hash;

import java.util.*;

public class TreeMapDemo {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("lily","1");
        hashMap.put("andy","12");
        hashMap.put("qin","123");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println("key: "+entry.getKey()+", value: "+entry.getValue());
        }
        ArrayList<Map.Entry<String, String>> list = new ArrayList<>(hashMap.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //升序排序
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }

        });

        for(Map.Entry<String,String> mapping:list){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
        for (int i=0;i<list.size();i++)
            System.out.println(list.get(i));
    }
}
