package com.example.demo.designpatterns.strategy;

import com.example.demo.enums.SnapshotTaskEnum;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author wan yu
 * @date 2022/4/22 下午4:25
 */
@Service
public class Hotel implements Strategy {


    @PostConstruct
    public void init(){
        StrategyContext.registerStrategy(SnapshotTaskEnum.COMPANY.name(), this);
    }

    @Override
    public void issue(Object... params) {
        System.out.println("酒旅服务");
    }
}
