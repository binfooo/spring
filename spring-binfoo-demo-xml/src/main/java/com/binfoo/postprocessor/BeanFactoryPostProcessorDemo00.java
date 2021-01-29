package com.binfoo.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

@Component
public class BeanFactoryPostProcessorDemo00 implements BeanFactoryPostProcessor, PriorityOrdered {

	@Override
	public int getOrder() {
		return 10;
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// System.out.println("com.binfoo.postprocessor.BeanFactoryPostProcessorDemo00");
	}
}
