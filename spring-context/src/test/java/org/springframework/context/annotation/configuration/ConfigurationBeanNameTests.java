

package org.springframework.context.annotation.configuration;

import org.junit.Test;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Unit tests ensuring that configuration class bean names as expressed via @Configuration
 * or @Component 'value' attributes are indeed respected, and that customization of bean
 * naming through a BeanNameGenerator strategy works as expected.
 *
 * @author Chris Beams
 * @since 3.1.1
 */
public class ConfigurationBeanNameTests {

	@Test
	public void registerOuterConfig() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(A.class);
		ctx.refresh();
		assertThat(ctx.containsBean("outer"), is(true));
		assertThat(ctx.containsBean("imported"), is(true));
		assertThat(ctx.containsBean("nested"), is(true));
		assertThat(ctx.containsBean("nestedBean"), is(true));
	}

	@Test
	public void registerNestedConfig() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(A.B.class);
		ctx.refresh();
		assertThat(ctx.containsBean("outer"), is(false));
		assertThat(ctx.containsBean("imported"), is(false));
		assertThat(ctx.containsBean("nested"), is(true));
		assertThat(ctx.containsBean("nestedBean"), is(true));
	}

	@Test
	public void registerOuterConfig_withBeanNameGenerator() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.setBeanNameGenerator(new AnnotationBeanNameGenerator() {
			@Override
			public String generateBeanName(
					BeanDefinition definition, BeanDefinitionRegistry registry) {
				return "custom-" + super.generateBeanName(definition, registry);
			}
		});
		ctx.register(A.class);
		ctx.refresh();
		assertThat(ctx.containsBean("custom-outer"), is(true));
		assertThat(ctx.containsBean("custom-imported"), is(true));
		assertThat(ctx.containsBean("custom-nested"), is(true));
		assertThat(ctx.containsBean("nestedBean"), is(true));
	}

	@Configuration("outer")
	@Import(C.class)
	static class A {
		@Component("nested")
		static class B {
			@Bean public String nestedBean() { return ""; }
		}
	}

	@Configuration("imported")
	static class C {
		@Bean public String s() { return "s"; }
	}
}
