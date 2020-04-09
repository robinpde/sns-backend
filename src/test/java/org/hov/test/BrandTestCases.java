package org.hov.test;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.UUID;

import org.hov.config.AppConfig;
import org.hov.model.Brand;
import org.hov.service.BrandService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class BrandTestCases {
	@Autowired
	BrandService brandService;
	
	@Test
	@Ignore
	public void addBrandValid1() {
		Brand b = new Brand();
		b.setBrandDescription("Brand 2 desc");
		assertTrue(brandService.addBrand(b));
	}
	
	@Test
	@Ignore
	public void updateBrand() {
		Brand b = brandService.getBrandById(UUID.fromString("6f256704-ae5b-46e0-869c-50b8bcf814d6"));
		b.setBrandName("Nike");
		assertTrue(brandService.updateBrand(b));
	}

	@Test
	@Ignore
	public void removeBrand() {
		assertTrue(brandService.removeBrand(UUID.fromString("6f256704-ae5b-46e0-869c-50b8bcf814d6")));
	}
	
	@Test
	@Ignore
	public void getAllBrand() {
		List<Brand> blist =  brandService.getAllBrands();
		for(Brand b:blist) {
			System.out.println(b.getBrandDescription());
		}
		assertTrue(true);
	}
}
