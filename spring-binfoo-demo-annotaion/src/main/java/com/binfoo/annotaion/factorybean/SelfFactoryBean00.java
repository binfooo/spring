package com.binfoo.annotaion.factorybean;

import com.binfoo.annotaion.bean.Bird;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

@Service
public class SelfFactoryBean00 implements FactoryBean<Bird> {

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public Bird getObject() {
        return new Bird("myBird", 1);
    }

    @Override
    public Class<?> getObjectType() {
        return Bird.class;
    }

    private void initMethod() {
        System.out.println("SelfFactoryBean00 开始初始化 ...");
    }

    private void destory() {
        System.out.println("SelfFactoryBean00 开始销毁 ...");
    }

}
