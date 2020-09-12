package com.example.demo.springStudy.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author mayongbo
 * @Description
 * @date 2020/4/15 11:30
 */
@Configuration
public class SonClass extends SuperClass {

    @Override
    protected void testConfig() {
        System.out.println("++++++++++++++++++++++++sonClass test");
    }
}
