package org.hov.dao;

import java.util.List;
import java.util.UUID;

import org.hov.model.SubCategory;

public interface SubCategoryDAO {
	public boolean addSubCategory(SubCategory subCategory);
	public boolean updateSubCategory(SubCategory subCategory);
	public boolean deleteSubCategory(UUID subCategoryId);
	public SubCategory getSubCategoryById(UUID subCategoryId);
	public List<SubCategory> getSubCategoryList();
}
