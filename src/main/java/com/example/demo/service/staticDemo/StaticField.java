package com.example.demo.service.staticDemo;

public class StaticField {
    public static int i=0;

    public static void main(String[] args) {
        StaticField s1 = new StaticField();
        s1.i =10;
        System.out.println(s1.i);
        System.out.println(StaticField.i);
        StaticField s2 = new StaticField();
        s2.i =20;
        System.out.println(s2.i);
        System.out.println(StaticField.i);
    }
}
