

package org.springframework.util.comparator;

import java.util.Comparator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Tests for {@link BooleanComparator}.
 *
 * @author Keith Donald
 * @author Chris Beams
 * @author Phillip Webb
 */
public class BooleanComparatorTests {

	@Test
	public void shouldCompareWithTrueLow() {
		Comparator<Boolean> c = new BooleanComparator(true);
		assertThat(c.compare(true, false), is(-1));
		assertThat(c.compare(Boolean.TRUE, Boolean.TRUE), is(0));
	}

	@Test
	public void shouldCompareWithTrueHigh() {
		Comparator<Boolean> c = new BooleanComparator(false);
		assertThat(c.compare(true, false), is(1));
		assertThat(c.compare(Boolean.TRUE, Boolean.TRUE), is(0));
	}

	@Test
	public void shouldCompareFromTrueLow() {
		Comparator<Boolean> c = BooleanComparator.TRUE_LOW;
		assertThat(c.compare(true, false), is(-1));
		assertThat(c.compare(Boolean.TRUE, Boolean.TRUE), is(0));
	}

	@Test
	public void shouldCompareFromTrueHigh() {
		Comparator<Boolean> c = BooleanComparator.TRUE_HIGH;
		assertThat(c.compare(true, false), is(1));
		assertThat(c.compare(Boolean.TRUE, Boolean.TRUE), is(0));
	}

}
