package com.juint.mockit.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldRestController.class)
class HelloWorldControllerTest {
	
	@Autowired
	private MockMvc mockmvc;
	
	@Test
	void helloClientTest() throws Exception {
		RequestBuilder builder = MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockmvc.perform(builder)
				.andExpect(status().is(200))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello Client"))
				.andReturn();
		//assertEquals("Helo Client", result.getResponse().toString());
		// assertEquals("Helo Client", result.getResponse().getContentAsString());
	}
}
