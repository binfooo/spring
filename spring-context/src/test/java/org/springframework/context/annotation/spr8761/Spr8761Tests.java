

package org.springframework.context.annotation.spr8761;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Tests cornering the regression reported in SPR-8761.
 *
 * @author Chris Beams
 */
public class Spr8761Tests {

	/**
	 * Prior to the fix for SPR-8761, this test threw because the nested MyComponent
	 * annotation was being falsely considered as a 'lite' Configuration class candidate.
	 */
	@Test
	public void repro() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan(getClass().getPackage().getName());
		ctx.refresh();
		assertThat(ctx.containsBean("withNestedAnnotation"), is(true));
	}

}

@Component
class WithNestedAnnotation {

	@Retention(RetentionPolicy.RUNTIME)
	@Component
	public static @interface MyComponent {
	}
}
