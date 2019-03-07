package com.xiaonei.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain1 {

	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		TestService ts=(TestService) ac.getBean("testService");
		System.out.println(ts.getName());

	}

}
