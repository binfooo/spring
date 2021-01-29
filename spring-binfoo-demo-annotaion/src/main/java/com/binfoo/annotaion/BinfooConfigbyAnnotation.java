package com.binfoo.annotaion;

import com.binfoo.annotaion.bean.Person;
import com.binfoo.annotaion.condition.Person00Conditional;
import com.binfoo.annotaion.condition.Person01Conditional;
import com.binfoo.annotaion.factorybean.SelfFactoryBean00;
import com.binfoo.annotaion.imports.SelfImportBeanDefinitionRegistrar00;
import com.binfoo.annotaion.init.SelfInitConstruct;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.binfoo"
        /*excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Component.class),
        }*/)
// 组件自定义导入
@Import(value = {
        // SelfImport00.class, SelfImport01.class
        // SelfImportSelector00.class
        SelfImportBeanDefinitionRegistrar00.class
})
public class BinfooConfigbyAnnotation {

    @Primary
    @Bean(name = "person20201230112515")
    // 根据一定的条件，决定 Bean 组件是否装配
    @Conditional(value = {
            Person00Conditional.class, Person01Conditional.class
    })
    public Person person() {
        return new Person();
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destory")
    public SelfFactoryBean00 selfFactoryBean00() {
        return new SelfFactoryBean00();
    }

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(BinfooConfigbyAnnotation.class);

        System.out.println("打印所有 beans 开始 =======");
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("打印所有 beans 结束 =======");

        // context.getBean(SelfImport00.class).sayHello();
        // System.out.println(context.getBean(BinfooDemoService.class));
        // System.out.println(context.getBean(BinfooDemoService.class));

        System.out.println(context.getBean("selfFactoryBean00"));
        System.out.println(context.getBean("selfFactoryBean00"));
        System.out.println(context.getBean(SelfInitConstruct.class));
        System.out.println(context.getBean(SelfFactoryBean00.class));
        System.out.println(context.getBean(BeanFactory.FACTORY_BEAN_PREFIX + "selfFactoryBean00"));

        context.getAutowireCapableBeanFactory().destroyBean(SelfFactoryBean00.class);

        System.out.println(context.getBean("selfFactoryBean00"));
    }
}
