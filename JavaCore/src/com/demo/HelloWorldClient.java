package com.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

 

public class HelloWorldClient {
	static class AThread extends Thread{
		public AThread() {
			// TODO Auto-generated constructor stub
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			JaxWsProxyFactoryBean svr = new JaxWsProxyFactoryBean();
			svr.setServiceClass(HelloWorld.class);
			svr.setAddress("http://localhost:8083/helloWorld");
			HelloWorld hw = (HelloWorld) svr.create();
			User user = new User();
			user.setName("Tony");
			user.setDescription("test");
//			System.out.println(hw.sayHiToUser(user) + "  "+Thread.currentThread());
		}
	}
	public static void main(String[] args) {
		long a = System.currentTimeMillis();
		int i = 0;
		while(i<100){
			AThread aThread = new AThread();
			aThread.start();
		}
		System.out.println( (System.currentTimeMillis()-a) / 1000);
		
	}
}