package com.example.demo;

import com.example.demo.dao.user.UserDao;
import com.example.demo.designpatterns.template.Tea;
import com.example.demo.domain.InvoiceIssueRecordDO;
import com.example.demo.domain.User;
import com.example.demo.service.InvoiceIssueRecord.IInvoiceIssueRecordService;
import com.example.demo.service.student.IStudentService;
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
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	@Autowired
	private IUserService userService;

	@Autowired
	private ProxyDemoService proxyDemoService;

	@Autowired
	private UserDao userDao;

	@Autowired
	private IStudentService studentService;

	@Autowired
	private IInvoiceIssueRecordService iInvoiceIssueRecordService;

	@Autowired
	private Tea tea;



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
	public void testTemplate(){
		tea.prepareBeverageTemplate();
	}


	@Test
	public void testDeleteDeadlock() throws InterruptedException {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("Thread：" + Thread.currentThread().getName() + "准备...");
					//cyclicBarrier一定要等到满200个线程到了才往后执行
					cyclicBarrier.await();
					System.out.println("Thread：" + Thread.currentThread().getName() + "开始执行");
					//do something
					int i = studentService.deleteByAgeAndClassId(35, 8);
					System.out.println("Thread：" + Thread.currentThread().getName() + "执行结束");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("Thread：" + Thread.currentThread().getName() + "准备...");
					//cyclicBarrier一定要等到满200个线程到了才往后执行
					cyclicBarrier.await();
					System.out.println("Thread：" + Thread.currentThread().getName() + "开始执行");
					//do something
					int i = studentService.deleteByAgeAndClassId(35, 8);
					System.out.println("Thread：" + Thread.currentThread().getName() + "执行结束");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("Thread：" + Thread.currentThread().getName() + "准备...");
					//cyclicBarrier一定要等到满200个线程到了才往后执行
					cyclicBarrier.await();
					System.out.println("Thread：" + Thread.currentThread().getName() + "开始执行");
					//do something
					int i = studentService.deleteByAgeAndClassId(35, 8);
					System.out.println("Thread：" + Thread.currentThread().getName() + "执行结束");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		thread1.start();
		thread2.start();
		thread3.start();
		System.out.println("******************************************");
		Thread.sleep(1* 60 * 1000);

	}

	@Test
	public void testUpdateDeadlock() throws InterruptedException {
		int count = 300;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(count);
		ExecutorService executorService = Executors.newFixedThreadPool(count);

		int n = 0;

		for (int i = 0; i < count; i++) {
			if (n % 2 == 0){
				executorService.execute(new TaskQuery(cyclicBarrier, n, iInvoiceIssueRecordService));
			}else {
				executorService.execute(new TaskUpdate(cyclicBarrier, n, iInvoiceIssueRecordService));
			}
			n++;

		}
		System.out.println("******************************************");
		Thread.sleep(1* 60 * 1000);

	}

	public class TaskQuery implements Runnable{
		private CyclicBarrier cyclicBarrier;
		int n = 0;
		private IInvoiceIssueRecordService iInvoiceIssueRecordService;

		public TaskQuery(CyclicBarrier cyclicBarrier ,int n, IInvoiceIssueRecordService iInvoiceIssueRecordService) {
			this.cyclicBarrier = cyclicBarrier;
			this.n = n;
			this.iInvoiceIssueRecordService = iInvoiceIssueRecordService;
		}

		@Override
		public void run() {
			System.out.println("Thread：" + n + " 准备...");
			//cyclicBarrier一定要等到满200个线程到了才往后执行
			try {
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			System.out.println("Thread：" + n + "开始执行");
			//do something
			List<InvoiceIssueRecordDO> recordByRequestNo = iInvoiceIssueRecordService.getRecordByRequestNo("12345678923");
			System.out.println("Thread：" + n + "执行结束");
		}
	}

	public class TaskUpdate implements Runnable{
		private CyclicBarrier cyclicBarrier;
		int n = 0;
		private IInvoiceIssueRecordService iInvoiceIssueRecordService;

		public TaskUpdate(CyclicBarrier cyclicBarrier ,int n, IInvoiceIssueRecordService iInvoiceIssueRecordService) {
			this.cyclicBarrier = cyclicBarrier;
			this.n = n;
			this.iInvoiceIssueRecordService = iInvoiceIssueRecordService;
		}

		@Override
		public void run() {
			System.out.println("Thread：" + n + " 准备...");
			//cyclicBarrier一定要等到满200个线程到了才往后执行
			try {
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			System.out.println("Thread：" + n + "开始执行");
			//do something
			int i = iInvoiceIssueRecordService.updateById(null);
			System.out.println("+++++++++++++++++++++：" + i + "更新结果");
			System.out.println("Thread：" + n + "执行结束");
		}
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
