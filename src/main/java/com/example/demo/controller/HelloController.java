package com.example.demo.controller;

import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class HelloController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/hello")
    public String home(@RequestParam String name){
        return "Hello World,"+name+", I am from "+port;
    }

    @RequestMapping("/helloNew")
    @ResponseBody
    public User homeNew(@RequestParam String name){
        User user = new User();
        user.setUserName(name);
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
