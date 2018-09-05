package com.example.demo.controller;

import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class HelloController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/hello")
    public String home(@RequestParam String name){
        return "Hello World,"+name+", I am from "+port;
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
