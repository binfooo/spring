

package org.springframework.web.servlet.view.tiles3;

import org.apache.tiles.TilesException;
import org.apache.tiles.preparer.ViewPreparer;

import org.springframework.web.context.WebApplicationContext;

/**
 * Tiles {@link org.apache.tiles.preparer.PreparerFactory} implementation
 * that expects preparer bean names and obtains preparer beans from the
 * Spring ApplicationContext. The full bean creation process will be in
 * the control of the Spring application context in this case, allowing
 * for the use of scoped beans etc.
 *
 * @author Juergen Hoeller
 * @since 3.2
 * @see SimpleSpringPreparerFactory
 */
public class SpringBeanPreparerFactory extends AbstractSpringPreparerFactory {

	@Override
	protected ViewPreparer getPreparer(String name, WebApplicationContext context) throws TilesException {
		return context.getBean(name, ViewPreparer.class);
	}

}
