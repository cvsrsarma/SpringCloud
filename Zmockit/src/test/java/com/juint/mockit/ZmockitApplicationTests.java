package com.juint.mockit;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ZmockitApplicationTests {

	//@Value("{external.server.url}")
	//String uri;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Test
	void contextLoads() {
		String resp=restTemplate().getForObject("http://localhost:8080/listofitems", String.class);
		assertEquals(0, 0);
	}

}
