

package org.springframework.ejb.config;

import org.w3c.dom.Element;

import org.springframework.ejb.access.SimpleRemoteStatelessSessionProxyFactoryBean;

/**
 * {@link org.springframework.beans.factory.xml.BeanDefinitionParser}
 * implementation for parsing '{@code remote-slsb}' tags and
 * creating {@link SimpleRemoteStatelessSessionProxyFactoryBean} definitions.
 *
 * @author Rob Harrop
 * @author Juergen Hoeller
 * @since 2.0
 */
class RemoteStatelessSessionBeanDefinitionParser extends AbstractJndiLocatingBeanDefinitionParser {

	@Override
	protected String getBeanClassName(Element element) {
		return "org.springframework.ejb.access.SimpleRemoteStatelessSessionProxyFactoryBean";
	}

}
