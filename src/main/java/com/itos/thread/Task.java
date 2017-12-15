package com.itos.thread;

public class Task implements Runnable{

	String name;
	
	public Task(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		
		System.out.println(name + " is running");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(name + " is running");
	}

}