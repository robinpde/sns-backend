package org.hov.model;

import java.net.URL;
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
@Table(name = "brands")
public class Brand {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID brandId;
	
	@Column(name = "brand_name")
	@NotBlank(message = "SNSERR000001")											//Cannot Be Empty
	private String brandName;

	@Column(name = "brand_tag_line")
	@NotBlank(message = "SNSERR000001")											//Cannot Be Empty
	private String brandTagline;

	@Column(name = "brand_description")
	@NotBlank(message = "SNSERR000001")											//Cannot Be Empty
	private String brandDescription;

	@Column(name = "brand_logo_url")
	@NotBlank(message = "SNSERR000001")											//Cannot Be Empty
	private URL brandLogo;

	@NotNull
	private boolean visible;

	public UUID getBrandId() {
		return brandId;
	}

	public URL getBrandLogo() {
		return brandLogo;
	}

	public void setBrandLogo(URL brandLogo) {
		this.brandLogo = brandLogo;
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

	public URL getBrandLogoURL() {
		return brandLogo;
	}

	public void setBrandLogoURL(URL brandLogoURL) {
		this.brandLogo = brandLogoURL;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}