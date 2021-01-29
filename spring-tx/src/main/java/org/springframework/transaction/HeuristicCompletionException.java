

package org.springframework.transaction;

/**
 * Exception that represents a transaction failure caused by a heuristic
 * decision on the side of the transaction coordinator.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @since 17.03.2003
 */
@SuppressWarnings("serial")
public class HeuristicCompletionException extends TransactionException {

	/**
	 * Values for the outcome state of a heuristically completed transaction.
	 */
	public static final int STATE_UNKNOWN = 0;
	public static final int STATE_COMMITTED = 1;
	public static final int STATE_ROLLED_BACK = 2;
	public static final int STATE_MIXED = 3;


	public static String getStateString(int state) {
		switch (state) {
			case STATE_COMMITTED:
				return "committed";
			case STATE_ROLLED_BACK:
				return "rolled back";
			case STATE_MIXED:
				return "mixed";
			default:
				return "unknown";
		}
	}


	/**
	 * The outcome state of the transaction: have some or all resources been committed?
	 */
	private int outcomeState = STATE_UNKNOWN;


	/**
	 * Constructor for HeuristicCompletionException.
	 * @param outcomeState the outcome state of the transaction
	 * @param cause the root cause from the transaction API in use
	 */
	public HeuristicCompletionException(int outcomeState, Throwable cause) {
		super("Heuristic completion: outcome state is " + getStateString(outcomeState), cause);
		this.outcomeState = outcomeState;
	}

	/**
	 * Return the outcome state of the transaction state,
	 * as one of the constants in this class.
	 * @see #STATE_UNKNOWN
	 * @see #STATE_COMMITTED
	 * @see #STATE_ROLLED_BACK
	 * @see #STATE_MIXED
	 */
	public int getOutcomeState() {
		return outcomeState;
	}

}
