package com.example.demo.threadStudy.lock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotifyTest {

	private static volatile Object resourceA = new Object();

	public static void main(String[] args) throws InterruptedException {
		Thread threadA = new Thread(() -> {
				synchronized (resourceA){
					log.info("threadA get resourceA lock");

					try{
						log.info("threadA begins to wait");
						resourceA.wait();
						log.info("threadA ends wait");
					}catch (InterruptedException e){
						log.error(e.getMessage());
					}
				}
		});

		Thread threadB = new Thread(() -> {
			synchronized (resourceA){
				log.info("threadB get resourceA lock");

				try{
					log.info("threadB begins to wait");
					resourceA.wait();
					log.info("threadB ends wait");
				}catch (InterruptedException e){
					log.error(e.getMessage());
				}
			}
		});

		Thread threadC = new Thread(() -> {
			synchronized (resourceA){
				log.info("threadC begin to notify");
				resourceA.notifyAll();
			}
		});

		threadA.start();
		threadB.start();

		Thread.sleep(1000);

		threadC.start();

		threadA.join();
		System.out.println("A 执行没");
		threadB.join();
		System.out.println("B 执行没");
		threadC.join();

		log.info("main thread over now");
	}
}