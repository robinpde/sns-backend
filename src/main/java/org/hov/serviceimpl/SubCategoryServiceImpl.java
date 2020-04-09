package org.hov.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.hov.dao.SubCategoryDAO;
import org.hov.model.SubCategory;
import org.hov.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryServiceImpl implements SubCategoryService{
	@Autowired
	SubCategoryDAO subCategoryDAO;

	@Override
	public boolean addSubCategory(SubCategory subCategory) {
		return subCategoryDAO.addSubCategory(subCategory);
	}

	@Override
	public boolean updateSubCategory(SubCategory subCategory) {
		return subCategoryDAO.updateSubCategory(subCategory);
	}

	@Override
	public boolean removeSubCategory(UUID subCategoryId) {
		return subCategoryDAO.deleteSubCategory(subCategoryId);
	}

	@Override
	public SubCategory getSubCategoryById(UUID subCategoryId) {
		return subCategoryDAO.getSubCategoryById(subCategoryId);
	}

	@Override
	public List<SubCategory> getSubCategoryList() {
		return subCategoryDAO.getSubCategoryList();
	}
}