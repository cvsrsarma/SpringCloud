package com.juint.mockit.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.juint.mockit.model.Item;
import com.juint.mockit.service.ItemBusinessServices;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class) 
class ItemControllerTest {
	
	@Autowired
	MockMvc mvc;
	
	@MockBean
	private ItemBusinessServices service;

	@Test
	void dummyItemTest() throws Exception {
		RequestBuilder request= MockMvcRequestBuilders.get("/dummyitem").accept(MediaType.APPLICATION_JSON);
		
		
		MvcResult result = mvc.perform(request)
				.andExpect(status().is(200))
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"item1\",\"price\":10,\"quanity\":100}"))
				.andReturn();
	}
	
	@Test
	void getIteamBusinessService_Test() throws Exception {
		RequestBuilder request= MockMvcRequestBuilders.get("/item-from-business-services").accept(MediaType.APPLICATION_JSON);
		when(service.retreiveHardCodedIteam()).thenReturn(new Item(1, "item1", 10,100));
		
		MvcResult result = mvc.perform(request)
				.andExpect(status().is(200))
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"item1\",\"price\":10,\"quanity\":100}"))
				.andReturn();
	}
	
	@Test
	void getAllItems_Test() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders.get("/listofitems").accept(MediaType.APPLICATION_JSON);
		when(service.getAllItems()).thenReturn(getItemList());
		
		MvcResult result = mvc.perform(request).andExpect(status().is(200))
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"id\":1,\"name\":\"item1\",\"price\":10,\"quanity\":100},{\"id\":2,\"name\":\"item2\",\"price\":10,\"quanity\":100}]"))
				.andReturn();
	}
	
	private List<Item> getItemList(){
		List<Item> aList = new ArrayList<Item>();
		aList.add(new Item(1, "item1", 10,100) );
		aList.add(new Item(2, "item2", 10,100) );
		return aList;
	}
}

class test{}
