package com.example.demo.controller;

import com.example.demo.service.retry.RetryService;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author wan yu
 * @date 2022/1/26 下午4:32
 */
@Controller
@EnableRetry
public class TestRetryController {

    @Resource
    private RetryService retryService;


    @ResponseBody
    @GetMapping("/callChannel")
    public String callChannel() throws Exception {
        retryService.callChannel();
        return "OK";
    }
}
