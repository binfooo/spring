package com.binfoo.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

@Component
public class BeanDefinitionRegistryPostProcessorDemo00
		implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {

	@Override
	public int getOrder() {
		return 11;
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("com.binfoo.postprocessor.BeanFactoryPostProcessorDemo00");
	}
}
