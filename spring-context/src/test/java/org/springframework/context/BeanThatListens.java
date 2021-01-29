

package org.springframework.context;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * A stub {@link ApplicationListener}.
 *
 * @author Thomas Risberg
 * @author Juergen Hoeller
 */
public class BeanThatListens implements ApplicationListener<ApplicationEvent> {

	private BeanThatBroadcasts beanThatBroadcasts;

	private int eventCount;


	public BeanThatListens() {
	}

	public BeanThatListens(BeanThatBroadcasts beanThatBroadcasts) {
		this.beanThatBroadcasts = beanThatBroadcasts;
		Map<?, BeanThatListens> beans = beanThatBroadcasts.applicationContext.getBeansOfType(BeanThatListens.class);
		if (!beans.isEmpty()) {
			throw new IllegalStateException("Shouldn't have found any BeanThatListens instances");
		}
	}


	@Override
	public void onApplicationEvent(@NotNull ApplicationEvent event) {
		eventCount++;
		if (beanThatBroadcasts != null) {
			beanThatBroadcasts.receivedCount++;
		}
	}

	public int getEventCount() {
		return eventCount;
	}

	public void zero() {
		eventCount = 0;
	}

}
