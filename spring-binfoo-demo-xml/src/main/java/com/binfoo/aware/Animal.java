package com.binfoo.aware;

import org.springframework.beans.factory.BeanNameAware;

public class Animal implements BeanNameAware {

	private String name;
	private String beanName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeanName() {
		return beanName;
	}

	@Override
	public void setBeanName(String name) {
		beanName = name;
	}
}
