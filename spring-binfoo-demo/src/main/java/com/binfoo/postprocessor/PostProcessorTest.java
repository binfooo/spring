package com.binfoo.postprocessor;

import com.binfoo.entity.UserConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class PostProcessorTest implements BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		Class<UserConfig> userConfigClass = UserConfig.class;
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(userConfigClass);
		BeanDefinition rawBeanDefinition = builder.getRawBeanDefinition();
		registry.registerBeanDefinition("userConfig", rawBeanDefinition);
	}
}
