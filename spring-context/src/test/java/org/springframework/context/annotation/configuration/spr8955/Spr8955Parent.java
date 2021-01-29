

package org.springframework.context.annotation.configuration.spr8955;

import org.springframework.stereotype.Component;

/**
 * @author Chris Beams
 * @author Willem Dekker
 */
abstract class Spr8955Parent {

	@Component
	static class Spr8955Child extends Spr8955Parent {

	}

}
