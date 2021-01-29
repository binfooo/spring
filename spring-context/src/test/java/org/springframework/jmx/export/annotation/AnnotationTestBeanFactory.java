

package org.springframework.jmx.export.annotation;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.jmx.IJmxTestBean;

/**
 * @author Juergen Hoeller
 */
public class AnnotationTestBeanFactory implements FactoryBean<FactoryCreatedAnnotationTestBean> {

	private final FactoryCreatedAnnotationTestBean instance = new FactoryCreatedAnnotationTestBean();

	public AnnotationTestBeanFactory() {
		this.instance.setName("FACTORY");
	}

	@Override
	public FactoryCreatedAnnotationTestBean getObject() throws Exception {
		return this.instance;
	}

	@Override
	public Class<? extends IJmxTestBean> getObjectType() {
		return FactoryCreatedAnnotationTestBean.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
