package com.binfoo.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BeanConstructorTest implements InitializingBean {

	@Override
	public void afterPropertiesSet() {
		System.out.println("com.binfoo.init.BeanConstructorTest.afterPropertiesSet");
	}

	@PostConstruct
	public void initMethod() {
		System.out.println("com.binfoo.init.BeanConstructorTest.initMethod");
	}
}
