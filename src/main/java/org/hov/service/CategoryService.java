package org.hov.service;

import java.util.List;
import java.util.UUID;

import org.hov.model.Category;

public interface CategoryService {
	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public Category getCategoryById(UUID categoryId);
	public List<Category> getAllCategories();
}
