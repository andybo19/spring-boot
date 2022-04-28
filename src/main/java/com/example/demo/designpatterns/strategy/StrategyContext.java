package com.example.demo.designpatterns.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wan yu
 * @date 2022/4/22 下午4:21
 */
public class StrategyContext {

    private static final Map<String, Strategy> registerMap = new HashMap<>();
    // 注册策略
    public static void registerStrategy(String rewardType, Strategy strategy) {
        registerMap.putIfAbsent(rewardType, strategy);
    }
    // 获取策略
    public static Strategy getStrategy(String rewardType) {
        return registerMap.get(rewardType);
    }

}
