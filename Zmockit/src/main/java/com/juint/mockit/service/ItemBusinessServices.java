package com.juint.mockit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juint.mockit.model.Item;
import com.juint.mockit.repo.ItemRepo;

@Service
public class ItemBusinessServices {
	
	@Autowired
	private ItemRepo repo;

	public Item retreiveHardCodedIteam() {
		return (new Item(1, "item1", 10, 100));
	}
	
	public List<Item> getAllItems(){
		List<Item> itemList = repo.findAll();
		itemList.forEach(n->n.setValue(n.getPrice()*2));
		return itemList;
	}
}
