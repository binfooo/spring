package com.binfoo;

import com.binfoo.demo.BinfooSerivce;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableAsync
@EnableScheduling
@ComponentScan(basePackages = "com.binfoo")
public class BinfooDemo {

	public static void main(String[] args) {
		// ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:springConfig.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(BinfooDemo.class);
		BinfooSerivce serivce = context.getBean(BinfooSerivce.class);
		serivce.sayHello("zhangsan");
		// System.out.println(serivce);

		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
	}
}
