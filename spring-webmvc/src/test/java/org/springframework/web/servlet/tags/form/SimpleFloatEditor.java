

package org.springframework.web.servlet.tags.form;

import java.beans.PropertyEditorSupport;

/**
 * @author Rob Harrop
 * @since 2.0
 */
class SimpleFloatEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(new Float(text));
	}

	@Override
	public String getAsText() {
		return getValue() + "f";
	}
}
