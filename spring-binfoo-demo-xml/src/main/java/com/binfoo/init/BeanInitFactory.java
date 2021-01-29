package com.binfoo.init;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class BeanInitFactory implements FactoryBean<String> {

	@Override
	public String getObject() {
		return "Hello World";
	}

	@Override
	public Class<?> getObjectType() {
		return String.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
