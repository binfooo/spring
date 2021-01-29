

package org.springframework.context.support;

import org.springframework.aop.framework.AbstractSingletonProxyFactoryBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

@SuppressWarnings("serial")
public class TestProxyFactoryBean extends AbstractSingletonProxyFactoryBean implements BeanFactoryAware {

	@Override
	protected Object createMainInterceptor() {
		return new NoOpAdvice();
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) {
	}

}
