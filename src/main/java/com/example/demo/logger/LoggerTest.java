package com.example.demo.logger;

import com.example.demo.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wan yu
 * @date 2023/3/21 下午7:56
 */
public class LoggerTest {

    public static void main(String[] args) {
        User user = new User();
        Logger logger = LoggerFactory.getLogger(LoggerTest.class);
        logger.trace("trace调用 {} 打印日志", logger.getName());
        logger.debug("debug调用 {} 打印日志", logger.getName());
        logger.info("info调用 {} 打印日志", logger.getName());
        logger.warn("warn调用 {} 打印日志", logger.getName());
        logger.error("error调用 {} 打印日志", logger.getName());
    }
}
