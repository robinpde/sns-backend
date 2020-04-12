package org.hov.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

	@Column(name = "category_desc")
	private String categoryDescription;
	
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
}