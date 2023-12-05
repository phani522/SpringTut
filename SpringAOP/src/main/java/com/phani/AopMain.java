package com.phani;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		Shape shape=(Shape) context.getBean("shape");
		shape.getTr().setNameandReturn("phani");
		System.out.println("shape is "+shape.getTr().getName());
		//shape.getTr().retEx("phani");

	}

}
