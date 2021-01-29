

package org.springframework.test.context.junit4.spr4868;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Sam Brannen
 * @since 3.2
 */
class LifecycleBean {

	private final Log logger = LogFactory.getLog(LifecycleBean.class);


	@PostConstruct
	public void init() {
		logger.info("initializing");
	}

	@PreDestroy
	public void destroy() {
		logger.info("destroying");
	}

}