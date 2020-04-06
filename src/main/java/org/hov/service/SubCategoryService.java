package org.hov.service;

import java.util.List;
import java.util.UUID;

import org.hov.model.SubCategory;

public interface SubCategoryService {
	public boolean addCategory(SubCategory subCategory);
	public boolean updateCategory(SubCategory subCategory);
	public SubCategory getCategoryById(UUID subCategoryId);
	public List<SubCategory> getAllCategories();
}
