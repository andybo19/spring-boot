package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class HelloController {
    @Value("${server.port}")
    private String port;
    @Autowired
    IUserService userService;

    @RequestMapping("/hello")
    public String home(@RequestParam String name){
        return "Hello World,"+name+", I am from "+port;
    }

    @RequestMapping("/testUser")
    public String testUser(User user){
        return "Hello World,"+user.getUserName()+", I am from "+port;
    }

    @RequestMapping("/helloNew")
    @ResponseBody
    public User homeNew(@RequestParam String name){
        User user = new User();
        user.setUserName(name);
        userService.insert(user);
        return user;
    }

    @RequestMapping(value = "/postUser")
    @ResponseBody
    public User homeNew(@RequestBody User user){
        user.setUserName("测试");
        return user;
    }

    @GetMapping("/HelloWorld")
    public String  getInfo(ModelMap map,String bo){
        System.out.println(bo);
        Date date = new Date();
        System.out.println("andy");
        map.addAttribute("andy",bo);
        User user = new User();
        user.setUserName("qin");
        user.setMobileNumber("15136456879");
        map.addAttribute(user);
        return "hello";
    }
}
