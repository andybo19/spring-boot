package com.example.demo.designpatterns.strategy;

import com.example.demo.enums.SnapshotTaskEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author wan yu
 * @date2022/4/22 下午4:25
 */
@Service("waimai")
public class Waimai implements Strategy {

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init(){
        Map<String, Strategy> beansOfType = applicationContext.getBeansOfType(Strategy.class);
        Strategy waimai = applicationContext.getBean(SnapshotTaskEnum.WAIMAI.getBeanName(), Strategy.class);
        StrategyContext.registerStrategy(SnapshotTaskEnum.WAIMAI.name(), waimai);
    }

    @Override
    @Transactional
    public void issue(Object... params) {
        System.out.println("+++++++++++++++++++++++");
        System.out.println("外卖服务");
    }
}
