package org.hov.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.hov.dao.ItemDAO;
import org.hov.model.Item;
import org.hov.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	ItemDAO itemDAO;
	
	@Override
	public boolean addItem(Item item) {
		return itemDAO.addItem(item);
	}

	@Override
	public boolean updateItem(Item item) {
		return itemDAO.updateItem(item);
	}

	@Override
	public boolean removeItem(UUID itemId) {
		return itemDAO.deleteItem(itemId);
	}
	
	@Override
	public Item getItemById(UUID itemId) {
		return itemDAO.getItemById(itemId);
	}

	@Override
	public List<Item> getItemList() {
		return itemDAO.getItemList();
	}
}