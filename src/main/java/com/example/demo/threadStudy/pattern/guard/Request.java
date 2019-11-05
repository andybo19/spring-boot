package com.example.demo.threadStudy.pattern.guard;

/**
 * @author mayongbo
 * @date 2019/10/29 16:50
 */
public class Request {
    private final String name;

    public Request(String name){
        this.name =name;
    }

    public String getName() {
        return name;
    }
    public String toString() {
        return "[ Request " + name + " ]";
    }

}
