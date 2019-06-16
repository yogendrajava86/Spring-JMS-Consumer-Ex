package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.config.AppConfig;
import com.app.listener.MyAppJmsListener;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
		MyAppJmsListener m=ac.getBean("myAppJmsListener", MyAppJmsListener.class);
	}

}
