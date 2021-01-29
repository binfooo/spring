

package org.springframework.orm.jpa.persistenceunit;

/**
 * Callback interface for post-processing a JPA PersistenceUnitInfo.
 * Implementations can be registered with a DefaultPersistenceUnitManager
 * or via a LocalContainerEntityManagerFactoryBean.
 *
 * @author Juergen Hoeller
 * @since 2.0
 * @see DefaultPersistenceUnitManager#setPersistenceUnitPostProcessors
 * @see org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean#setPersistenceUnitPostProcessors
 */
public interface PersistenceUnitPostProcessor {

	/**
	 * Post-process the given PersistenceUnitInfo, for example registering
	 * further entity classes and jar files.
	 * @param pui the chosen PersistenceUnitInfo, as read from {@code persistence.xml}.
	 * Passed in as MutablePersistenceUnitInfo.
	 */
	void postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo pui);

}
