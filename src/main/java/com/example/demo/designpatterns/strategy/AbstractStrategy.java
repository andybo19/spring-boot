package com.example.demo.designpatterns.strategy;

/**
 * @author wan yu
 * @date 2022/4/22 下午4:22
 */
public class AbstractStrategy implements Strategy {
    @Override
    public void issue(Object... params) {

    }

    // 类注册方法
    public void register(String type, Strategy strategy) {
        StrategyContext.registerStrategy(type, strategy);
    }
}
