

package org.springframework.ejb.config;

import org.w3c.dom.Element;

import org.springframework.ejb.access.LocalStatelessSessionProxyFactoryBean;

/**
 * {@link org.springframework.beans.factory.xml.BeanDefinitionParser}
 * implementation for parsing '{@code local-slsb}' tags and
 * creating {@link LocalStatelessSessionProxyFactoryBean} definitions.
 *
 * @author Rob Harrop
 * @author Juergen Hoeller
 * @since 2.0
 */
class LocalStatelessSessionBeanDefinitionParser extends AbstractJndiLocatingBeanDefinitionParser {

	@Override
	protected String getBeanClassName(Element element) {
		return "org.springframework.ejb.access.LocalStatelessSessionProxyFactoryBean";
	}

}
