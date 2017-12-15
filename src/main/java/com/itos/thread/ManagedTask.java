package com.itos.thread;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ManagedTask implements Runnable{

	String name;
	
	public void setName(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		
		System.out.println(name + " is running");
		
		long starttime = System.currentTimeMillis();
		
		for( long i = 0; i < 1000000000 ; i++)
		{
			
		}
		long endtime = System.currentTimeMillis();
		System.out.println(this.name + " time :"+ Long.toString(endtime -starttime));
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/

	}

}