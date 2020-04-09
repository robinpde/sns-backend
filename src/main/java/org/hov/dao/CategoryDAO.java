package org.hov.dao;

import java.util.List;
import java.util.UUID;

import org.hov.model.Category;

public interface CategoryDAO {
	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(UUID categoryId);
	public Category getCategoryById(UUID categoryId);
	public List<Category> getAllCategories();
}
