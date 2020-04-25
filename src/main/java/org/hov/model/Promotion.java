package org.hov.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	private UUID promoid;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "linked_item")
	private Item linkedItem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "linked_vendor")
	private Vendor linkedVendor;

	@Column(name = "promotion_type")
	@Enumerated(EnumType.ORDINAL)
	private PromoType promoType;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "picture_meta_file")
	private MetaFile pictureMetaFile;
	
	//@OneToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "payment_link")
	//private PaymentLink paymentLink;
	
	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "expiry_date")
	private Date expiryDate;
	
	@Column(name = "read_count")
	private long readCount;
	
	@NotNull
	private boolean active;

	public UUID getPromoid() {
		return promoid;
	}

	public void setPromoid(UUID promoid) {
		this.promoid = promoid;
	}

	public PromoType getPromoType() {
		return promoType;
	}

	public void setPromoType(PromoType promoType) {
		this.promoType = promoType;
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
	
	public Item getLinkedItem() {
		return linkedItem;
	}

	public void setLinkedItem(Item linkedItem) {
		this.linkedItem = linkedItem;
	}

	public Vendor getLinkedVendor() {
		return linkedVendor;
	}

	public void setLinkedVendor(Vendor linkedVendor) {
		this.linkedVendor = linkedVendor;
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