package org.hov.test;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.UUID;

import org.hov.config.AppConfig;
import org.hov.model.SubCategory;
import org.hov.service.SubCategoryService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(AppConfig.class)
public class SubCategoryTestCases {
	@Autowired
	SubCategoryService subCategoryService;
	
	@Test
	@Ignore
	public void addSubCategoryValid1() {
		SubCategory sc = new SubCategory();
		sc.setSubCategoryName("subCategoryName1");
		assertTrue(subCategoryService.addSubCategory(sc));
	}
	
	@Test
	@Ignore
	public void updateSubCategoryValid1() {
		SubCategory sc = subCategoryService.getSubCategoryById(UUID.fromString("c3cb944c-828d-4b09-b5ab-e410a0414396"));
		sc.setSubCategoryName("subCategoryName2");
		assertTrue(subCategoryService.updateSubCategory(sc));
	}
	
	@Test
	@Ignore
	public void deleteSubCategoryValid1() {
		assertTrue(subCategoryService.removeSubCategory(UUID.fromString("c3cb944c-828d-4b09-b5ab-e410a0414396")));
	}
	
	@Test
	@Ignore
	public void getSubCategoryList() {
		List<SubCategory> sclist = subCategoryService.getSubCategoryList();
		for(SubCategory sc:sclist) {
			System.out.println(sc.getSubCategoryName());
		}
	}
}
