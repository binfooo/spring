

package org.springframework.scheduling.config;

import org.w3c.dom.Element;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;

/**
 * Parser for the 'scheduler' element of the 'task' namespace.
 *
 * @author Mark Fisher
 * @since 3.0
 */
public class SchedulerBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

	@Override
	protected String getBeanClassName(Element element) {
		return "org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler";
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		String poolSize = element.getAttribute("pool-size");
		if (StringUtils.hasText(poolSize)) {
			builder.addPropertyValue("poolSize", poolSize);
		}
	}

}
