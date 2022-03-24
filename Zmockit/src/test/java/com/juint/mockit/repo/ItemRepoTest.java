package com.juint.mockit.repo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.juint.mockit.model.Item;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
class ItemRepoTest {
	
	@Autowired
	ItemRepo repo;
	
	  @Autowired
	  private TestEntityManager entityManager;

	@Test
	void findAll_Test() {
		List<Item> itemList=repo.findAll();
		
		assertEquals(4,itemList.size());
	}

}
