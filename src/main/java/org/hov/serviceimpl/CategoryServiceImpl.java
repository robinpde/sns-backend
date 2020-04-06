package org.hov.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.hov.dao.CategoryDAO;
import org.hov.model.Category;
import org.hov.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDAO categoryDAO;

	@Override
	public boolean addCategory(Category category) {
		if(categoryDAO.addCategory(category) != null){
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean updateCategory(Category category) {
		return categoryDAO.updateCategory(category);
	}

	@Override
	public Category getCategoryById(UUID categoryId) {
		return categoryDAO.getCategoryById(categoryId);
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryDAO.getAllCategories();
	}
}