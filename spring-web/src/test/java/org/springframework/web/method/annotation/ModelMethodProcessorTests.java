

package org.springframework.web.method.annotation;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import org.springframework.core.MethodParameter;
import org.springframework.mock.web.test.MockHttpServletRequest;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

import static org.junit.Assert.*;

/**
 * Test fixture with {@link org.springframework.web.method.annotation.ModelMethodProcessor}.
 *
 * @author Rossen Stoyanchev
 */
public class ModelMethodProcessorTests {

	private ModelMethodProcessor processor;

	private ModelAndViewContainer mavContainer;

	private MethodParameter paramModel;

	private MethodParameter returnParamModel;

	private NativeWebRequest webRequest;

	@Before
	public void setUp() throws Exception {
		processor = new ModelMethodProcessor();
		mavContainer = new ModelAndViewContainer();

		Method method = getClass().getDeclaredMethod("model", Model.class);
		paramModel = new MethodParameter(method, 0);
		returnParamModel = new MethodParameter(method, -1);

		webRequest = new ServletWebRequest(new MockHttpServletRequest());
	}

	@Test
	public void supportsParameter() {
		assertTrue(processor.supportsParameter(paramModel));
	}

	@Test
	public void supportsReturnType() {
		assertTrue(processor.supportsReturnType(returnParamModel));
	}

	@Test
	public void resolveArgumentValue() throws Exception {
		assertSame(mavContainer.getModel(), processor.resolveArgument(paramModel, mavContainer, webRequest, null));
	}

	@Test
	public void handleModelReturnValue() throws Exception {
		mavContainer.addAttribute("attr1", "value1");
		Model returnValue = new ExtendedModelMap();
		returnValue.addAttribute("attr2", "value2");

		processor.handleReturnValue(returnValue , returnParamModel, mavContainer, webRequest);

		assertEquals("value1", mavContainer.getModel().get("attr1"));
		assertEquals("value2", mavContainer.getModel().get("attr2"));
	}

	@SuppressWarnings("unused")
	private Model model(Model model) {
		return null;
	}

}