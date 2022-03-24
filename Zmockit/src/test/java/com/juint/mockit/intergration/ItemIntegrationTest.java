package com.juint.mockit.intergration;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemIntegrationTest {
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	
	
	@Test
	public void contextLoads() throws JSONException {
		
		String resp=restTemplate().getForObject("http://localhost:8080/listofitems", String.class);
		//JSONAssert.assertEquals(null, null, false)
		JSONAssert.assertEquals("[{id:1,name:Item1},{id:2,name:Item2},{id:3,name:Item3},{id:4,name:Item4}]", resp, false);
	}
}
