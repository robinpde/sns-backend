package org.hov.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "items")
public class Item {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID ItemId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "linked_vendor")
	private Vendor vendor;
	
	@Column(name = "item_name")
	@NotBlank(message = "SNSERR000001")											//Cannot Be Empty
	private String itemName;
	
	@Column(name = "item_price")
	private double itemPrice;

	public UUID getItemId() {
		return ItemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
}