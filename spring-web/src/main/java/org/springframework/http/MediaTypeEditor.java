

package org.springframework.http;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;

/**
 * {@link java.beans.PropertyEditor Editor} for {@link MediaType}
 * descriptors, to automatically convert {@code String} specifications
 * (e.g. {@code "text/html"}) to {@code MediaType} properties.
 *
 * @author Juergen Hoeller
 * @since 3.0
 * @see MediaType
 */
public class MediaTypeEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) {
		if (StringUtils.hasText(text)) {
			setValue(MediaType.parseMediaType(text));
		}
		else {
			setValue(null);
		}
	}

	@Override
	public String getAsText() {
		MediaType mediaType = (MediaType) getValue();
		return (mediaType != null ? mediaType.toString() : "");
	}

}
