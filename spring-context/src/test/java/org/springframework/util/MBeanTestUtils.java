

package org.springframework.util;

import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;

/**
 * Utilities for MBean tests.
 *
 * @author Phillip Webb
 */
public class MBeanTestUtils {

	/**
	 * Resets MBeanServerFactory and ManagementFactory to a known consistent state.
	 * This involves releasing all currently registered MBeanServers and resetting
	 * the platformMBeanServer to null.
	 */
	public static void resetMBeanServers() throws Exception {
		for (MBeanServer server : MBeanServerFactory.findMBeanServer(null)) {
			MBeanServerFactory.releaseMBeanServer(server);
		}
		Field field = ManagementFactory.class.getDeclaredField("platformMBeanServer");
		field.setAccessible(true);
		field.set(null, null);
	}

}
