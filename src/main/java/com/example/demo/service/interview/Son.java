package com.example.demo.service.interview;

public class Son extends Father {
    public void Son(){
        System.out.println("son init ++++++++++++++");
    }


    public Son (String name){
        System.out.println(name + ",son init ++++++++++++++");
    }


    public static void main(String[] args) {
        Son son = new Son("jack");
        System.out.println(3&5);

    }
}
