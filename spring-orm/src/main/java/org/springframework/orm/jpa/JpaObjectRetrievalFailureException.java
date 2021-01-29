

package org.springframework.orm.jpa;

import javax.persistence.EntityNotFoundException;

import org.springframework.orm.ObjectRetrievalFailureException;

/**
 * JPA-specific subclass of ObjectRetrievalFailureException.
 * Converts JPA's EntityNotFoundException.
 *
 * @author Juergen Hoeller
 * @since 2.0
 * @see EntityManagerFactoryUtils#convertJpaAccessExceptionIfPossible
 */
@SuppressWarnings("serial")
public class JpaObjectRetrievalFailureException extends ObjectRetrievalFailureException {

	public JpaObjectRetrievalFailureException(EntityNotFoundException ex) {
		super(ex.getMessage(), ex);
	}

}
