package com.example.demo.springStudy.config;

import com.example.demo.domain.User;
import org.springframework.context.annotation.Bean;

/**
 * @author mayongbo
 * @Description
 * @date 2020/4/15 11:27
 */
public class SuperClass {

    @Bean
    public User user(){
        System.out.println("++++++++++++++++++++++配置user bean");
        return new User();
    }

    protected void testConfig(){
        System.out.println("++++++++++++++++++++++superClass test");
    }
}
