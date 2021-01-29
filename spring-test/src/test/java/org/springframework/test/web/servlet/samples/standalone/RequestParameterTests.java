
package org.springframework.test.web.servlet.samples.standalone;

import org.junit.Test;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * Tests demonstrating the use of request parameters.
 *
 * @author Rossen Stoyanchev
 */
public class RequestParameterTests {

	@Test
	public void queryParameter() throws Exception {

		standaloneSetup(new PersonController()).build()
			.perform(get("/search?name=George").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.name").value("George"));
	}


	@Controller
	private class PersonController {

		@RequestMapping(value="/search")
		@ResponseBody
		public Person get(@RequestParam String name) {
			Person person = new Person(name);
			return person;
		}
	}

}
