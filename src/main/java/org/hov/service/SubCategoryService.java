package org.hov.service;

import java.util.List;
import java.util.UUID;

import org.hov.model.SubCategory;

public interface SubCategoryService {
	public boolean addSubCategory(SubCategory subCategory);
	public boolean updateSubCategory(SubCategory subCategory);
	public boolean removeSubCategory(UUID subCategoryId);
	public SubCategory getSubCategoryById(UUID subCategoryId);
	public List<SubCategory> getSubCategoryList();
}
