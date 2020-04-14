package org.hov.model;

import java.net.URL;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "items")
public class Item {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID itemid;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "linked_vendor")
	private Vendor vendor;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "item_desc", length = 510)
	private String itemDescription;
	
	@Column(name = "item_price")
	private double itemPrice;

	@Column(name = "items_on_stock")
	private int itemsOnStock;
	
	@Column(name = "image_url")
	private URL imageURL;
	
	public UUID getItemid() {
		return itemid;
	}

	public void setItemid(UUID itemid) {
		this.itemid = itemid;
	}

	public URL getImageURL() {
		return imageURL;
	}

	public void setImageURL(URL imageURL) {
		this.imageURL = imageURL;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getItemsOnStock() {
		return itemsOnStock;
	}

	public void setItemsOnStock(int itemsOnStock) {
		this.itemsOnStock = itemsOnStock;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
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