

package org.springframework.test.web.servlet.samples.standalone.resultmatchers;

import org.junit.Before;
import org.junit.Test;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * Examples of expectations on created request attributes.
 *
 * @author Rossen Stoyanchev
 */
public class RequestAttributeAssertionTests {

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = standaloneSetup(new SimpleController()).build();
	}

	@Test
	public void testRequestAttributeEqualTo() throws Exception {
		this.mockMvc.perform(get("/main/1").servletPath("/main"))
			.andExpect(request().attribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE, "/{id}"))
			.andExpect(request().attribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE, "/1"))
			.andExpect(request().attribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE, equalTo("/{id}")))
			.andExpect(request().attribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE, equalTo("/1")));
	}

	@Test
	public void testRequestAttributeMatcher() throws Exception {

		String producibleMediaTypes = HandlerMapping.PRODUCIBLE_MEDIA_TYPES_ATTRIBUTE;

		this.mockMvc.perform(get("/1"))
			.andExpect(request().attribute(producibleMediaTypes, hasItem(MediaType.APPLICATION_JSON)))
			.andExpect(request().attribute(producibleMediaTypes, not(hasItem(MediaType.APPLICATION_XML))));
	}


	@Controller
	private static class SimpleController {

		@RequestMapping(value="/{id}", produces="application/json")
		public String show() {
			return "view";
		}
	}

}
