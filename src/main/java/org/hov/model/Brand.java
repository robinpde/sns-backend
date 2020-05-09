package org.hov.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "brands")
public class Brand {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID brandid;
	
	@Column(name = "brand_name")
	private String brandName;

	@Column(name = "brand_tag_line")
	private String brandTagline;

	@Column(name = "brand_desc", length = 800)
	private String brandDescription;
	
	@OneToOne
	@JoinColumn(name = "picture_meta_file")
	private MetaFile pictureMetaFile;

	private boolean active;

	public UUID getBrandid() {
		return brandid;
	}

	public void setBrandid(UUID brandid) {
		this.brandid = brandid;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandTagline() {
		return brandTagline;
	}

	public void setBrandTagline(String brandTagline) {
		this.brandTagline = brandTagline;
	}

	public String getBrandDescription() {
		return brandDescription;
	}

	public void setBrandDescription(String brandDescription) {
		this.brandDescription = brandDescription;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/* PICTURE META FILE HELPER FUNCTIONS */
	public MetaFile getPictureMetaFile() {
		return pictureMetaFile;
	}
	
	public void setPictureMetaFile(MetaFile pictureMetaFile) {
		this.pictureMetaFile = pictureMetaFile;
	}

	public void addPictureMetaFile(MetaFile file) {
		if(file!=null) {
			this.pictureMetaFile = file;
			file.setLinked(true);
		}
	}
	
	public void removePictureMetaFile() {
		this.setPictureMetaFile(null);
		this.getPictureMetaFile().setLinked(false);
	}
}