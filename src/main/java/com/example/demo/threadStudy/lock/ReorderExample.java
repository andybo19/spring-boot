package com.example.demo.threadStudy.lock;

public class ReorderExample {

	private int x = 0;
	private int y = 1;
	private volatile boolean flag = false;

	public void writer(){
		x = 42;	//1
		y = 50;	//2
		flag = true;	//3
	}

	public void reader(){
		if (flag){	//4
			System.out.println("x:" + x);	//5
			System.out.println("y:" + y);	//6
		}
	}
}