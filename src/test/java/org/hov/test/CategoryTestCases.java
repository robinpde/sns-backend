package org.hov.test;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.UUID;

import org.hov.config.AppConfig;
import org.hov.model.Category;
import org.hov.service.CategoryService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class CategoryTestCases {
	@Autowired
	CategoryService categoryService;
	
	@Test
	@Ignore
	public void addCategoryValid1() {
		Category c = new Category();
		c.setCategoryName("Sample Text");
		assertTrue(categoryService.addCategory(c));
	}
	
	@Test
	@Ignore
	public void updateCategoryValid1() {
		Category c = categoryService.getCategoryById(UUID.fromString("8ec86204-23af-473a-8eac-e399ee1a7ff6"));
		c.setCategoryDescription("Updated Desc1");
		assertTrue(categoryService.updateCategory(c));
	}
	
	@Test
	@Ignore
	public void removeCategoryValid1() {
		assertTrue(categoryService.removeCategory(UUID.fromString("8ec86204-23af-473a-8eac-e399ee1a7ff6")));
	}
	
	@Test
	@Ignore
	public void getAllCategoryValid1() {
		List<Category> clist = categoryService.getAllCategories();
		for(Category c:clist) {
			System.out.println(c.getCategoryName());
		}
		assertTrue(true);
	}
}
