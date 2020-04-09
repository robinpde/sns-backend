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
		return categoryDAO.addCategory(category);
	}

	@Override
	public boolean updateCategory(Category category) {
		return categoryDAO.updateCategory(category);
	}
	
	@Override
	public boolean removeCategory(UUID categoryId) {
		return categoryDAO.deleteCategory(categoryId);
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