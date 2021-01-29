

package org.springframework.context.annotation.configuration.spr8955;

import org.junit.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Chris Beams
 * @author Willem Dekker
 */
public class Spr8955Tests {

	@Test
	public void repro() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("org.springframework.context.annotation.configuration.spr8955");
		ctx.refresh();
	}

}
