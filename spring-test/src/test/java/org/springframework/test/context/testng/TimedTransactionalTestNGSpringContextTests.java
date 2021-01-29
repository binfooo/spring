

package org.springframework.test.context.testng;

import org.testng.annotations.Test;

import org.springframework.test.context.ContextConfiguration;

import static org.springframework.test.transaction.TransactionTestUtils.*;

/**
 * Timed integration tests for
 * {@link AbstractTransactionalTestNGSpringContextTests}; used to verify claim
 * raised in <a href="https://jira.springframework.org/browse/SPR-6124"
 * target="_blank">SPR-6124</a>.
 *
 * @author Sam Brannen
 * @since 3.0
 */
@ContextConfiguration
public class TimedTransactionalTestNGSpringContextTests extends AbstractTransactionalTestNGSpringContextTests {

	@Test
	public void testWithoutTimeout() {
		assertInTransaction(true);
	}

	// TODO Enable TestNG test with timeout once we have a solution.
	@Test(timeOut = 10000, enabled = false)
	public void testWithTimeout() {
		assertInTransaction(true);
	}

}
