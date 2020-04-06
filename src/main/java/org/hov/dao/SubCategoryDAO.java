package org.hov.dao;

import java.util.List;
import java.util.UUID;

import org.hov.model.SubCategory;

public interface SubCategoryDAO {
	public UUID addCategory(SubCategory subCategory);
	public boolean updateCategory(SubCategory subCategory);
	public SubCategory getCategoryById(UUID subCategoryId);
	public List<SubCategory> getAllCategories();
}
