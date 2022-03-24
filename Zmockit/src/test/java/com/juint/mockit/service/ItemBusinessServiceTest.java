package com.juint.mockit.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.juint.mockit.model.Item;
import com.juint.mockit.repo.ItemRepo;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {
	
	@BeforeEach
	public void setup() {
		 MockitoAnnotations.initMocks(this);
	}
	
	@InjectMocks
	private ItemBusinessServices service;
	
	@Mock
	private ItemRepo repo;

	@Test
	void getAllItems_Test() {
		when(repo.findAll()).thenReturn(getItemList());
		
		
		
		List<Item> items = service.getAllItems();
		System.out.println(items);
		assertEquals(20, items.get(0).getValue());
		
		
	}

	private List<Item> getItemList() {
		List<Item> alist = new ArrayList<Item>();
		alist.add(new Item(1,	"Item1",	10,	100));
		alist.add(new Item(2,	"Item2",	11,	105));
		alist.add(new Item(3,	"Item3",	51,	505));
		return alist;
	}

}
