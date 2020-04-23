package org.hov.service;

import java.util.List;
import java.util.UUID;

import org.hov.model.Item;

public interface ItemService {
	public boolean addItem(Item item);
	public boolean updateItem(Item item);
	public boolean removeItem(UUID itemId);
	public Item getItemById(UUID itemId);
	public List<Item> getItemList();
	public List<Item> getItemListbyPrice(String order);
	public List<Item> getItemBySearch(String text);	
}
