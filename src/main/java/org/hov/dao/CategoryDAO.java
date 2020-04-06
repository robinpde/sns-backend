package org.hov.dao;

import java.util.List;
import java.util.UUID;

import org.hov.model.Category;

public interface CategoryDAO {
	public UUID addCategory(Category category);
	public boolean updateCategory(Category category);
	public Category getCategoryById(UUID categoryId);
	public List<Category> getAllCategories();
}
