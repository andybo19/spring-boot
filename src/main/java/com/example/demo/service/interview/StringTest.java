package com.example.demo.service.interview;

import com.example.demo.domain.User;

public class StringTest {


    public static void main(String[] args) {
       /* String str ="1234";
        changgeStr(str);
        System.out.println(str);*/

        StringTest test = new StringTest();
        int i=10;
        test.pass(i);
        System.out.println("print in main , i is " + i);


        User user = new User();
        user.setUserName("andy");
        user.setMobileNumber("123456");
        test.changgeUser(user);
        System.out.println("print in main , user is " + user);
    }

    private void changgeUser(User user) {
        user = new User();
        user.setUserName("hollischuang");
        System.out.println("print in pass , user is " + user);
    }


    public void pass(int j) {
        j = 20;
        System.out.println("print in pass , j is " + j);
    }

    private static void changgeStr(String str) {
        str = "welcome";
    }



}
