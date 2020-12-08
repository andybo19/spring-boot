package com.example.demo.springStudy.aop;

import com.example.demo.service.user.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.annotation.PostConstruct;

/**
 * @author mayongbo
 * @Description
 * @date 2020/4/10 15:20
 */

public class MySpringBean implements BeanNameAware, BeanFactoryAware, InitializingBean, ApplicationContextAware,ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(MySpringBean.class);

    @Autowired
    private IUserService userService;

    private ApplicationContext applicationContext;

    public MySpringBean(){
        logger.info("new MySpringBean......");
        logger.info("inti constructor:......" + userService);
    }

    @PostConstruct
    public void postConstruct(){
        logger.info("inti postConstruct:......" + userService);
    }



    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.info("BeanFactoryAware-setBeanFactory......");
        logger.info("inti setBeanFactory:......" + userService);
    }

    @Override
    public void setBeanName(String name) {
        logger.info("BeanNameAware-setBeanName......");
        logger.info("inti setBeanName:......" + userService);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("InitializingBean-afterPropertiesSet......");
        logger.info("inti afterPropertiesSet:......" + userService);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("ApplicationContextAware-setApplicationContext......");
        logger.info("inti setApplicationContext:......" + userService);
        this.applicationContext = applicationContext;
    }


    public void initMethod(){
        logger.info("init method  执行");
    }



    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info("inti onApplicationEvent:......" + userService);
    }
}
