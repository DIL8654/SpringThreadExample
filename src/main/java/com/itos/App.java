package com.itos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.itos.config.AppConfig;
import com.itos.thread.ManagedTask;

public class App {
	public static void main(String[] args) {


		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) context
				.getBean("taskExecutor");

		long starttime = System.currentTimeMillis();
		ManagedTask t1 = (ManagedTask) context.getBean("managedTask");
		t1.setName("T1");
		taskExecutor.execute(t1);

		ManagedTask t2 = (ManagedTask) context.getBean("managedTask");
		t2.setName("T2");
		taskExecutor.execute(t2);

		ManagedTask t3 = (ManagedTask) context.getBean("managedTask");
		t3.setName("T3");
		taskExecutor.execute(t3);


		taskExecutor.shutdown();
		long endtime = System.currentTimeMillis();
		while (!taskExecutor.getThreadPoolExecutor().isTerminated())
		{
		}

		System.out.println(" All thread are executed...! time taken : "+ Long.toString(endtime-starttime));
		
		System.out.println("=================================================================================");
		
		long stime = System.currentTimeMillis();
		ManagedTask task1 = new ManagedTask();
		task1.setName("task1");
		task1.run();
		ManagedTask task2 = new ManagedTask();
		task2.setName("task2");
		task2.run();
		ManagedTask task3= new ManagedTask();
		task3.setName("task3");
		task3.run();
		long etime = System.currentTimeMillis();
		
		System.out.println(" Procedure...! time taken : "+ Long.toString(etime-stime));
	}
}
