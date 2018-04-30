package com.wsc.dubbotest.consumer.pp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wsc.dubbotest.provider.service.DemoService;

public class Consumer {

	public static void main(String[] args) throws Exception {
		String providerInterfaceClassName="com.wsc.dubbotest.provider.service.DemoService";
		String prividerInterfaceMethodName="sayHello";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml" );
		context.start();
		System.out.println(Class.forName(providerInterfaceClassName).getName());
		System.out.println(Class.forName(providerInterfaceClassName));
//		Object vartemp = Class.forName(providerInterfaceClassName).getMethod(prividerInterfaceMethodName, null).invoke(context.getBean("demoService"), null);
//		System.out.println(vartemp);
		
		DemoService demoService = (DemoService) context.getBean("demoService");
		System.out.println(context.getBean("demoService").getClass());
		String var = demoService.sayHello("demo start");
		System.out.println("consumer:"+var);
		System.in.read();
	}

}