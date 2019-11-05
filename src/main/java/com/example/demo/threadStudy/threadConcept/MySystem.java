package com.example.demo.threadStudy.threadConcept;

import java.util.Date;

/**
 * @author mayongbo
 * @date 2019/10/29 15:43
 */
public class MySystem {

    /*private static MySystem instance = null;
    private Date date = new Date();

    private MySystem(){

    }

    public Date getDate(){
        return date;
    }

    public static MySystem getInstance(){
        if(instance == null){
            synchronized (MySystem.class){
                if(instance == null){
                    instance = new MySystem();
                }
            }
        }
        return instance;
    }*/

    private static MySystem instance = null;
    private Date date = new Date();

    private MySystem() {
    }
    public Date getDate() {
        return date;
    }
    public static MySystem getInstance() {
        if (instance == null) {
            synchronized (MySystem.class) {
                if (instance == null) {
                    instance = new MySystem();
                }
            }
        }
        return instance;
    }
}
