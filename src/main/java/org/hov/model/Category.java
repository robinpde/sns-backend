package org.hov.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID categoryid;
	
	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "category_desc", length = 510)
	private String categoryDescription;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<SubCategory> subCategoryList = new ArrayList<>();
	
	private boolean active;

	public UUID getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(UUID categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/* SUB-CATEGORY LIST HELPER FUNCTIONS */
	public List<SubCategory> getSubCategoryList() {
		return subCategoryList;
	}
	
	public void addSubCategory(SubCategory subcateg) {
		if(subcateg != null) {
			subcateg.setCategory(this);
			this.getSubCategoryList().add(subcateg);
		}
	}
	
	public void removeSubCategory(SubCategory subcateg) {
		if(subcateg != null) {
			subcateg.setCategory(null);
			this.getSubCategoryList().remove(subcateg);
		}
	}
	
}