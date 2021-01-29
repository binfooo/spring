

package org.springframework.test.context.junit4.spr9051;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Integration tests that verify proper scoping of beans created in
 * <em>{@code @Bean} Lite Mode</em>.
 *
 * @author Sam Brannen
 * @since 3.2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AtBeanLiteModeScopeTests.LiteBeans.class)
public class AtBeanLiteModeScopeTests {

	/**
	 * This is intentionally <b>not</b> annotated with {@code @Configuration}.
	 */
	static class LiteBeans {

		@Bean
		public LifecycleBean singleton() {
			LifecycleBean bean = new LifecycleBean("singleton");
			assertFalse(bean.isInitialized());
			return bean;
		}

		@Bean
		@Scope("prototype")
		public LifecycleBean prototype() {
			LifecycleBean bean = new LifecycleBean("prototype");
			assertFalse(bean.isInitialized());
			return bean;
		}
	}


	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	@Qualifier("singleton")
	private LifecycleBean injectedSingletonBean;

	@Autowired
	@Qualifier("prototype")
	private LifecycleBean injectedPrototypeBean;


	@Test
	public void singletonLiteBean() {
		assertNotNull(injectedSingletonBean);
		assertTrue(injectedSingletonBean.isInitialized());

		LifecycleBean retrievedSingletonBean = applicationContext.getBean("singleton", LifecycleBean.class);
		assertNotNull(retrievedSingletonBean);
		assertTrue(retrievedSingletonBean.isInitialized());

		assertSame(injectedSingletonBean, retrievedSingletonBean);
	}

	@Test
	public void prototypeLiteBean() {
		assertNotNull(injectedPrototypeBean);
		assertTrue(injectedPrototypeBean.isInitialized());

		LifecycleBean retrievedPrototypeBean = applicationContext.getBean("prototype", LifecycleBean.class);
		assertNotNull(retrievedPrototypeBean);
		assertTrue(retrievedPrototypeBean.isInitialized());

		assertNotSame(injectedPrototypeBean, retrievedPrototypeBean);
	}

}
