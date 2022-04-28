package com.example.demo.designpatterns.strategy;

/**
 * @author wan yu
 * @date 2022/4/22 下午4:41
 */
public class StrategyTest {

    public static void main(String[] args) {

        Strategy strategy = StrategyContext.getStrategy("Waimai");
        strategy.issue(new Object());
    }
}
