package com.juint.mockit.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
	
	String actualResponse="{\"id\":1,\"name\":\"item1\",\"price\":10,\"quanity\":100}";
	
	@Test
	public void jsonAssertTest() throws JSONException {
		System.out.println("Test");
		String expectedResponse="{\"id\":1,\"name\":\"item1\",\"price\":10,\"quanity\":100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}
	@Test
	public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
		String expectedResponse = "{\"id\": 1, \"name\":\"Ball\", \"price\":10, \"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}
}
