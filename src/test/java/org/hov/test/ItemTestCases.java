package org.hov.test;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.UUID;

import org.hov.config.AppConfig;
import org.hov.dao.ItemDAO;
import org.hov.model.Item;
import org.hov.service.ItemService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class ItemTestCases {
	@Autowired
	ItemService itemService;
	
	@Autowired
	ItemDAO itemDAO;
	
	@Test
	@Ignore
	public void addItemValid1() {
		Item i = new Item();
		i.setItemName("Sample1");
		assertTrue(itemService.addItem(i));
	}
	
	@Test
	@Ignore
	public void updateItemValid1() {
		Item i = itemService.getItemById(UUID.fromString("8158bacc-53a0-4269-9af5-7f8ab4b8a19d"));
		i.setItemPrice(600.00);
		System.out.println(i.getItemName());
		assertTrue(itemService.updateItem(i));
	}
	
	@Test
	@Ignore
	public void deleteItemValid1() {
		assertTrue(itemDAO.deleteItem(UUID.fromString("20d47910-a54a-49e5-8feb-3220cbad8b99")));
	}
	
	@Test
	@Ignore
	public void getAllItemsValid1() {
		List<Item> ilist = itemService.getItemList();
		for(Item i:ilist) {
			System.out.println(i.getItemName());
		}
		assertTrue(true);
	}
}