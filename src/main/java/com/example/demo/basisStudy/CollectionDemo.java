package com.example.demo.basisStudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author mayongbo
 * @Description
 * @date 2021/2/20 20:15
 */
public class CollectionDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        list.add("b");
        System.out.println("++++++++++++list"+list);
        System.out.println("++++++++++++unmodifiableList"+unmodifiableList);
    }

}
