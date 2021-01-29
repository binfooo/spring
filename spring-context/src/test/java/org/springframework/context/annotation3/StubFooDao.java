

package org.springframework.context.annotation3;

import example.scannable.FooDao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * @author Mark Fisher
 */
@Repository
@Qualifier("testing")
public class StubFooDao implements FooDao {

	@Override
	public String findFoo(int id) {
		return "bar";
	}

}
