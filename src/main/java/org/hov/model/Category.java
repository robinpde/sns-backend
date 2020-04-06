package org.hov.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID categoryId;
	
	@Column(name = "category_name")
	@NotBlank(message = "SNSERR000001")											//Cannot Be Empty
	private String categoryName;

	@Column(name = "categorry_description")
	@NotBlank(message = "SNSERR000001")											//Cannot Be Empty
	private String categoryDescription;
	
	@NotNull
	private boolean visible;

	public UUID getCategoryId() {
		return categoryId;
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

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}