package com.example.demo.domain;

import com.example.demo.domain.DataStructure.SingleLinkedList;

public class Test {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.addHead("A");
        list.addHead("B");
        list.addHead("C");
        //list.del("B");
        Object o = list.find("B");
        System.out.println(o);
        list.display();
    }
}
