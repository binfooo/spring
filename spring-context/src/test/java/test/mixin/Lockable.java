

package test.mixin;


/**
 * Simple interface to use for mixins
 *
 * @author Rod Johnson
 *
 */
public interface Lockable {

	void lock();

	void unlock();

	boolean locked();
}