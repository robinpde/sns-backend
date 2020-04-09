package org.hov.service;

import java.util.List;
import java.util.UUID;

import org.hov.model.Item;

public interface ItemService {
	public boolean addItem(Item item);
	public boolean updateItem(Item item);
	public Item getItemById(UUID itemId);
	public List<Item> getItemList();
}
