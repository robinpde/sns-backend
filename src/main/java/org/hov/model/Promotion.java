package org.hov.model;

import java.net.URL;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hov.enums.PromoType;

@Entity
@Table(name = "promotions")
public class Promotion {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID promoId;
	
	//@Column
	//@NotNull
	//private Item item;
	
	//@NotNull
	//private User user;
	
	//@NotNull
	//private Payment payment;

	@Column(name = "promotion_type")
	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private PromoType promoType;
	
	@NotNull
	private boolean active;

	@Column(name = "banner_url")
	private URL bannerURL;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "expiry_date")
	private Date expiryDate;
	
	@Column(name = "read_count")
	private long readCount;
	
	public UUID getPromoId() {
		return promoId;
	}

	public PromoType getPromoType() {
		return promoType;
	}

	public void setPromoType(PromoType promoType) {
		this.promoType = promoType;
	}

	public URL getBannerURL() {
		return bannerURL;
	}
	
	public void setBannerURL(URL bannerURL) {
		this.bannerURL = bannerURL;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getExpiryDate() {
		return expiryDate;
	}
	
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public long getReadCount() {
		return readCount;
	}
	
	public void setReadCount(long readCount) {
		this.readCount = readCount;
	}
}