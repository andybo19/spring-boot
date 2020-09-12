package com.example.demo.springStudy.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author mayongbo
 * @Description
 * @date 2020/4/10 15:25
 */
@Component
public class MySpringBeanPostProcessor implements BeanPostProcessor {

    private static final Logger logger = LoggerFactory.getLogger(MySpringBeanPostProcessor.class);

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MySpringBean) {
            logger.info("BeanPostProcessor-postProcessAfterInitialization......");
        }
        //logger.info("BeanPostProcessor-postProcessAfterInitialization......beanName:"+beanName);
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MySpringBean) {
            logger.info("BeanPostProcessor-postProcessBeforeInitialization......");
        }
        //logger.info("BeanPostProcessor-postProcessBeforeInitialization......beanName:"+beanName);
        return bean;
    }

}
