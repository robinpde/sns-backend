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
@Table(name = "sub_category")
public class SubCategory {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID subCategoryId;
	
	//private Category category;
	
	@Column(name = "sub_category_name")
	@NotBlank(message = "SNSERR000001")											//Cannot Be Empty
	private String subCategoryName;

	@Column(name = "sub_category_description")
	@NotBlank(message = "SNSERR000001")											//Cannot Be Empty
	private String subCategoryDescription;

	@NotNull
	private boolean visible;

	public UUID getSubCategoryId() {
		return subCategoryId;
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

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}