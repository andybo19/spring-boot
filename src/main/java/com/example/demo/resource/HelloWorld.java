package com.example.demo.resource;

import com.example.demo.dao.user.UserDao;
import com.example.demo.domain.User;
import com.example.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {

    @Autowired
    private String helloTest;

    @Autowired
    private UserDao userDao;

    @Autowired
    private IUserService userService;


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
    public User insertByMobile(String mobile,String name){
        User user = new User();
        user.setMobileNumber(mobile);
        user.setUserName(name);
        userService.insert(user);
        System.out.println(user.toString());
        return user;
    }


}
