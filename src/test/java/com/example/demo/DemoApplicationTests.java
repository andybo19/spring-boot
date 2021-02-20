package com.example.demo;

import com.example.demo.dao.user.UserDao;
import com.example.demo.domain.User;
import com.example.demo.service.user.IUserService;
import com.example.demo.service.user.ProxyDemoService;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	@Autowired
	private IUserService userService;

	@Autowired
	private ProxyDemoService proxyDemoService;

	@Autowired
	private UserDao userDao;

	@Test
	public void testDelete(){
		/*int delete = userDao.delete(12);
		System.out.println("+++++++++++++++++++++++++"+delete);*/
		PageHelper.startPage(4,3);
		List<User> userList = userDao.getListByPage("1");
		System.out.println("+++++++++++++结果"+userList);
		System.out.println("____________________________________");
/*		List<User> users = userDao.getList("1", PageBounds.page(4,3));
		System.out.println("+++++++++++++结果"+users);*/
	}

	@Test
	public void contextLoads() {
		//是否是JDK动态代理
		System.out.println("isJdkDynamicProxy => " + AopUtils.isJdkDynamicProxy(userService));
		//是否是CGLIB代理
		System.out.println("isCglibProxy => " + AopUtils.isCglibProxy(userService));
		//代理类的类型
		System.out.println("proxyClass => " + userService.getClass());
		//代理类的父类的类型
		System.out.println("parentClass => " + userService.getClass().getSuperclass());
		//代理类的父类实现的接口
		System.out.println("parentClass's interfaces => " + Arrays.asList(userService.getClass().getSuperclass().getInterfaces()));
		//代理类实现的接口
		System.out.println("proxyClass's interfaces => " + Arrays.asList(userService.getClass().getInterfaces()));
		//代理对象
		System.out.println("proxy => " + userService);
		//目标对象
		System.out.println("target => " + AopProxyUtils.getSingletonTarget(userService));
		//代理对象和目标对象是不是同一个
		System.out.println("proxy == target => " + (userService == AopProxyUtils.getSingletonTarget(userService)));

		Object target = AopProxyUtils.getSingletonTarget(userService);
		//目标类的类型
		System.out.println("targetClass => " + AopProxyUtils.getSingletonTarget(userService).getClass());
		//目标类实现的接口
		System.out.println("targetClass's interfaces => " + Arrays.asList(AopProxyUtils.getSingletonTarget(userService).getClass().getInterfaces()));
		userService.doNotneedTx();
		System.out.println("----------------------------------------------------");
		userService.doNeedTx();
	}

	@Test
	public void testProxy() {
		//是否是JDK动态代理
		System.out.println("isJdkDynamicProxy => " + AopUtils.isJdkDynamicProxy(proxyDemoService));
		//是否是CGLIB代理
		System.out.println("isCglibProxy => " + AopUtils.isCglibProxy(proxyDemoService));
		//代理类的类型
		System.out.println("proxyClass => " + proxyDemoService.getClass());
		//代理类的父类的类型
		System.out.println("parentClass => " + proxyDemoService.getClass().getSuperclass());
		//代理类的父类实现的接口
		System.out.println("parentClass's interfaces => " + Arrays.asList(proxyDemoService.getClass().getSuperclass().getInterfaces()));
		//代理类实现的接口
		System.out.println("proxyClass's interfaces => " + Arrays.asList(proxyDemoService.getClass().getInterfaces()));
		//代理对象
		System.out.println("proxy => " + proxyDemoService);
		//目标对象
		System.out.println("target => " + AopProxyUtils.getSingletonTarget(proxyDemoService));
		//代理对象和目标对象是不是同一个
		System.out.println("proxy == target => " + (proxyDemoService == AopProxyUtils.getSingletonTarget(proxyDemoService)));
		//目标类的类型
		System.out.println("targetClass => " + AopProxyUtils.getSingletonTarget(proxyDemoService).getClass());
		//目标类实现的接口
		System.out.println("targetClass's interfaces => " + Arrays.asList(AopProxyUtils.getSingletonTarget(proxyDemoService).getClass().getInterfaces()));
		proxyDemoService.doNotneedTx();
		System.out.println("----------------------------------------------------");
	}

}
