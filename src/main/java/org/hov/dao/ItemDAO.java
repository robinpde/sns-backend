package org.hov.dao;

import java.util.List;
import java.util.UUID;

import org.hov.model.Item;

public interface ItemDAO {
	public UUID addItem(Item item);
	public boolean updateItem(Item item);
	public Item getItemById(UUID itemId);
	public List<Item> getItemList();											//Suitable for Buyers
	public List<Item> getItemListFullDetails();									//Suitable for Sellers, Admins
}
