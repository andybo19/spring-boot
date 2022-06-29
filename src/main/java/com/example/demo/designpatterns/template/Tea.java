package com.example.demo.designpatterns.template;

import org.springframework.stereotype.Service;

/**
 * @author wan yu
 * @date 2022/5/19 下午5:30
 */
@Service
public class Tea extends AbstractTemplate{


    @Override
    protected void brew() {
        System.out.println("炮制绿茶");
    }

}
