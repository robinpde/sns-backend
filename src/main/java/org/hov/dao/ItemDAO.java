package org.hov.dao;

import java.util.List;
import java.util.UUID;

import org.hov.model.Item;

public interface ItemDAO {
	public boolean addItem(Item item);
	public boolean updateItem(Item item);
	public boolean deleteItem(UUID itemId);
	public Item getItemById(UUID itemId);
	public List<Item> getItemList();
	public List<Item> getItemListbyPrice();
	public List<Item> getItemListbyPriceDesc();
	public List<Item> getItemBySearch(String text);	
}
