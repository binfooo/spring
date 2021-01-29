

package org.springframework.context;

import org.jetbrains.annotations.NotNull;

/**
 * @author Juergen Hoeller
 */
public class BeanThatBroadcasts implements ApplicationContextAware {

	public ApplicationContext applicationContext;

	public int receivedCount;


	@Override
	public void setApplicationContext(@NotNull ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
		if (applicationContext.getDisplayName().indexOf("listener") != -1) {
			applicationContext.getBean("listener");
		}
	}

}
