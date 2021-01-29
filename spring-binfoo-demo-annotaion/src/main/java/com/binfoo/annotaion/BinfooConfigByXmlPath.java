package com.binfoo.annotaion;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BinfooConfigByXmlPath {

	public static void main(String[] args) {

		System.setProperty("spring1", "classpath");
		System.setProperty("spring2", "${spring1}");

		String[] locations = new String[]{"${spring2}:applicationConfig0.xml", "classpath:applicationConfig1.xml"};
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(locations, false);
		context.setAllowBeanDefinitionOverriding(false);
		context.setAllowCircularReferences(false);
		context.refresh();


		System.out.println("==== 所有注册成功的 BeanDefinition ====");
		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}

		// Car car = context.getBean(Car.class);
		// System.out.println(car.getCarAge());
	}
}
