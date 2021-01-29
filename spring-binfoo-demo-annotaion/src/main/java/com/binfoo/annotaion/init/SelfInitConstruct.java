package com.binfoo.annotaion.init;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Controller
// @Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class SelfInitConstruct implements InitializingBean, BeanPostProcessor, DisposableBean {

	@Override
	public void afterPropertiesSet() {
		System.out.println("初始化 SelfInitConstruct afterPropertiesSet");
	}

	@PostConstruct
	public void initMethod() {
		System.out.println("初始化 SelfInitConstruct PostConstruct");
	}

	@PreDestroy
	public void destoryMethod() {
		System.out.println("销毁 SelfInitConstruct destoryMethod");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("beanName1:" + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("beanName2:" + beanName);
		return bean;
	}

	@Override
	public void destroy() {
		System.out.println();
	}
}
