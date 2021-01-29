package com.binfoo.annotaion.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class Person00Conditional implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // BinfooDemoService binfooDemoService = beanFactory.getBeanNamesForType(BinfooDemoService.class);
        assert beanFactory != null;
		System.out.println(metadata);
        // BinfooDemoService binfooDemoService = beanFactory.getBean(BinfooDemoService.class);
        return true;
    }
}
