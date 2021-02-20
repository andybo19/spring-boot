package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ImportResource("classpath*:spring-context.xml")
public class DemoApplication {

	@Bean
	public String getStr(){
		return "这是一个字符串Bean";
	}


	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(DemoApplication.class, args);
		keepRuning();
	}

	private static void keepRuning() throws InterruptedException {
		Thread t = Thread.currentThread();
		synchronized (t){
			t.wait();
		}
	}
}
