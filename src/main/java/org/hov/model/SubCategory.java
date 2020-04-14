package org.hov.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "sub_category")
public class SubCategory {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID subcategoryid;
	
	//private Category category;
	
	@Column(name = "sub_category_name")
	private String subCategoryName;

	@Column(name = "sub_category_desc", length = 510)
	private String subCategoryDescription;

	private boolean active;

	public UUID getSubcategoryid() {
		return subcategoryid;
	}

	public void setSubcategoryid(UUID subcategoryid) {
		this.subcategoryid = subcategoryid;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public String getSubCategoryDescription() {
		return subCategoryDescription;
	}

	public void setSubCategoryDescription(String subCategoryDescription) {
		this.subCategoryDescription = subCategoryDescription;
	}
}