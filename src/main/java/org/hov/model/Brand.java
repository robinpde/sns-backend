package org.hov.model;

import java.net.URL;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

	@Column(name = "brand_description")
	private String brandDescription;

	@Column(name = "brand_logo_url")
	private URL brandLogo;

	private boolean active;

	public UUID getBrandid() {
		return brandid;
	}

	public void setBrandid(UUID brandid) {
		this.brandid = brandid;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}