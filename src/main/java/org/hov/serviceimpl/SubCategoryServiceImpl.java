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
	public boolean addCategory(SubCategory subCategory) {
		if(subCategoryDAO.addCategory(subCategory) != null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean updateCategory(SubCategory subCategory) {
		return subCategoryDAO.updateCategory(subCategory);
	}

	@Override
	public SubCategory getCategoryById(UUID subCategoryId) {
		subCategoryDAO.getCategoryById(subCategoryId);
		return null;
	}

	@Override
	public List<SubCategory> getAllCategories() {
		subCategoryDAO.getAllCategories();
		return null;
	}
}