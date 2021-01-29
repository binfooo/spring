package com.binfoo.annotaion.imports;

import com.binfoo.annotaion.bean.Student;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class SelfImportBeanDefinitionRegistrar00 implements ImportBeanDefinitionRegistrar {

    // @Override
    // public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry,
    //                                     BeanNameGenerator importBeanNameGenerator) {
    // }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinition beanDefinition = new RootBeanDefinition(Student.class);
        beanDefinition.setLazyInit(true);
        beanDefinition.setPrimary(true);
        beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        registry.registerBeanDefinition("student20201230150819", beanDefinition);
    }
}
