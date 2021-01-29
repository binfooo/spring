

package org.springframework.context.annotation.configuration;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ClassUtils;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class Spr7167Tests {
	@Test
	public void test() {
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);

		assertThat("someDependency was not post processed",
				ctx.getBeanFactory().getBeanDefinition("someDependency").getDescription(),
				equalTo("post processed by MyPostProcessor"));

		MyConfig config = ctx.getBean(MyConfig.class);
		assertTrue("Config class was not enhanced", ClassUtils.isCglibProxy(config));
	}
}

@Configuration
class MyConfig {

	@Bean
	public Dependency someDependency() {
		return new Dependency();
	}

	@Bean
	public BeanFactoryPostProcessor thePostProcessor() {
		return new MyPostProcessor(someDependency());
	}
}

class Dependency {
}

class MyPostProcessor implements BeanFactoryPostProcessor {

	public MyPostProcessor(Dependency someDependency) {
	}

	@Override
	public void postProcessBeanFactory(@NotNull ConfigurableListableBeanFactory beanFactory) throws BeansException {
		AbstractBeanDefinition bd = (AbstractBeanDefinition) beanFactory.getBeanDefinition("someDependency");
		bd.setDescription("post processed by MyPostProcessor");
	}
}
