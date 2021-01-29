

package org.springframework.tests.transaction;

import javax.transaction.Status;
import javax.transaction.Synchronization;
import javax.transaction.xa.XAResource;

/**
 * @author Juergen Hoeller
 * @since 31.08.2004
 */
public class MockJtaTransaction implements javax.transaction.Transaction {

	private Synchronization synchronization;

	@Override
	public int getStatus() {
		return Status.STATUS_ACTIVE;
	}

	@Override
	public void registerSynchronization(Synchronization synchronization) {
		this.synchronization = synchronization;
	}

	public Synchronization getSynchronization() {
		return synchronization;
	}

	@Override
	public boolean enlistResource(XAResource xaResource) {
		return false;
	}

	@Override
	public boolean delistResource(XAResource xaResource, int i) {
		return false;
	}

	@Override
	public void commit() {
	}

	@Override
	public void rollback() {
	}

	@Override
	public void setRollbackOnly() {
	}

}
