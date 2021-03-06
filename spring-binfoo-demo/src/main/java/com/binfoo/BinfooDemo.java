package com.binfoo;

import com.binfoo.entity.UserConfig;
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
		ApplicationContext context = new AnnotationConfigApplicationContext(BinfooDemo.class);
		UserConfig bean = context.getBean(UserConfig.class);
		System.out.println(bean);
	}
}
