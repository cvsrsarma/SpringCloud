package com.juint.mockit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juint.mockit.model.Item;
import com.juint.mockit.service.ItemBusinessServices;

@RestController
public class ItemController {
	
	@Autowired
	ItemBusinessServices businessServices;
	
	@GetMapping("/dummyitem")
	public Item getDummyItem() {
		Item item = new Item(1, "item1", 10,100);
		return item;
	}
	
	@GetMapping("/item-from-business-services")
	public Item getIteamBusinessService() {
		return businessServices.retreiveHardCodedIteam();
	}
	
	@GetMapping("/listofitems")
	public List<Item> getAllItems(){
		return businessServices.getAllItems();
	}
}
