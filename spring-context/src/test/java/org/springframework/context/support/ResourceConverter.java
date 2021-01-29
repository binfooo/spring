

package org.springframework.context.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 * @author Juergen Hoeller
 */
public class ResourceConverter implements Converter<String, Resource> {

	@Override
	public Resource convert(String source) {
		return new FileSystemResource(source + ".xml");
	}

}
