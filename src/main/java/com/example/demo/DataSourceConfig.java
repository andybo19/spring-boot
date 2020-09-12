package com.example.demo;

import com.example.demo.springStudy.aop.MySpringBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    @Bean(initMethod = "initMethod")
    public MySpringBean mySpringBean(){
        return  new MySpringBean();
    }
}
