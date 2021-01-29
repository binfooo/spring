

package org.springframework.jms.core;

/**
 * @author Juergen Hoeller
 * @since 06.01.2005
 */
public class JmsTemplateJtaTests extends JmsTemplateTests {

	@Override
	protected boolean useTransactedSession() {
		return true;
	}

	@Override
	protected boolean useTransactedTemplate() {
		return false;
	}

}
