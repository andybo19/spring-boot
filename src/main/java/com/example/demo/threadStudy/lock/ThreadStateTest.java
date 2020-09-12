package com.example.demo.threadStudy.lock;

public class ThreadStateTest {

	public static void main(String[] args) throws InterruptedException {
		/*Thread thread = new Thread(() -> {});
		System.out.println(thread.getState());
		thread.start();
		System.out.println(thread.getState());
		Thread.sleep(1000);
		System.out.println(thread.getState());
		System.out.println("+++++++++++++++++++++++");
		Thread t1 = new Thread(new DemoThreadB());
		Thread t2 = new Thread(new DemoThreadB());

		t2.start();
		t1.start();

		Thread.sleep(1000);
		System.out.println((t1.getState()));
		System.out.println((t2.getState()));
		System.exit(0);*/

		Thread main = Thread.currentThread();

		Thread thread2 = new Thread(() -> {
			try {
				Thread.sleep(1000000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
			System.out.println(main.getState());
		});
		thread2.start();
		thread2.join();
		System.out.println("join以后++++++++++++++++");
		System.out.println(main.getState());

		/*Thread thread3 = new Thread(() -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// 为什么要调用interrupt方法？
				Thread.currentThread().interrupt();
				e.printStackTrace();
				System.out.println("+++++++++++中断");
			}
		});
		thread3.start();
		System.out.println(thread3.getState());
		System.out.println("++++++++++++++++++++++++++");
		Thread.sleep(1000);
		System.out.println(thread3.getState());*/
	}
}

class DemoThreadB implements Runnable {
	@Override
	public void run() {
		commonResource();
	}

	public static synchronized void commonResource() {
		while(true) {
			
		}
	}
}