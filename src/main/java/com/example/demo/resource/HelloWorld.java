package com.example.demo.resource;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {

    @Autowired
    String helloTest;

    @Autowired
    UserDao userDao;


    @RequestMapping("/first")
    @ResponseBody
    public String demo(){
        return "Hello World Bean";
    }

    @RequestMapping("/second")
    @ResponseBody
    public String demo2(){
        return helloTest;
    }

    @GetMapping("/index")
    public String demo3(){

        return "/index.html";
    }


    @GetMapping("/get")
    @ResponseBody
    public User getUserByMobile(String mobile){
        User user = userDao.findByMobile(mobile);
        System.out.println(user.toString());
        return user;
    }

    @GetMapping("/insert")
    @ResponseBody
    @Transactional
    public User insertByMobile(String mobile){
        User user = new User();
        user.setMobileNumber("9874123564");
        user.setUserName("andyqin");
        userDao.insert(user);
        System.out.println(1/0);
        System.out.println(user.toString());
        return user;
    }


}
