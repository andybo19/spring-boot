package com.example.demo;

import com.example.demo.interceptor.CheckSQLInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mayongbo
 * @Description
 * @date 2021/2/20 11:23
 */
@Configuration
public class ConfigBean {

    @Bean
    public Interceptor getInterceptor(){
        return new CheckSQLInterceptor();
    }

}
