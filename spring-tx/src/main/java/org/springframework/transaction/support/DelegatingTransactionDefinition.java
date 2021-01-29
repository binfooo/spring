

package org.springframework.transaction.support;

import java.io.Serializable;

import org.springframework.lang.Nullable;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.util.Assert;

/**
 * {@link TransactionDefinition} implementation that delegates all calls to a given target
 * {@link TransactionDefinition} instance. Abstract because it is meant to be subclassed,
 * with subclasses overriding specific methods that are not supposed to simply delegate
 * to the target instance.
 *
 * @author Juergen Hoeller
 * @since 3.0
 */
@SuppressWarnings("serial")
public abstract class DelegatingTransactionDefinition implements TransactionDefinition, Serializable {

	private final TransactionDefinition targetDefinition;


	/**
	 * Create a DelegatingTransactionAttribute for the given target attribute.
	 * @param targetDefinition the target TransactionAttribute to delegate to
	 */
	public DelegatingTransactionDefinition(TransactionDefinition targetDefinition) {
		Assert.notNull(targetDefinition, "Target definition must not be null");
		this.targetDefinition = targetDefinition;
	}


	@Override
	public int getPropagationBehavior() {
		return this.targetDefinition.getPropagationBehavior();
	}

	@Override
	public int getIsolationLevel() {
		return this.targetDefinition.getIsolationLevel();
	}

	@Override
	public int getTimeout() {
		return this.targetDefinition.getTimeout();
	}

	@Override
	public boolean isReadOnly() {
		return this.targetDefinition.isReadOnly();
	}

	@Override
	@Nullable
	public String getName() {
		return this.targetDefinition.getName();
	}


	@Override
	public boolean equals(Object other) {
		return this.targetDefinition.equals(other);
	}

	@Override
	public int hashCode() {
		return this.targetDefinition.hashCode();
	}

	@Override
	public String toString() {
		return this.targetDefinition.toString();
	}

}
