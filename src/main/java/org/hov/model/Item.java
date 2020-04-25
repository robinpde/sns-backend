package org.hov.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand")
	private Brand brand;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category")
	private Category category;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sub_category")
	private SubCategory subCategory;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "images_list")
	private List<MetaFile> imagesList = new ArrayList<>();
	
	public UUID getItemid() {
		return itemid;
	}

	public void setItemid(UUID itemid) {
		this.itemid = itemid;
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

	/* IMAGESLIST SETTER IS INTENTIONAL FOR SORTING FUNCTION */
	public void setImagesList(List<MetaFile> imagesList) {
		this.imagesList = imagesList;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	/* IMAGESLIST HELPER FUNCTIONS */
	public List<MetaFile> getImagesList() {
		return imagesList;
	}
	
	public void addMetaFile(MetaFile file) {
		if(file != null) {
			this.getImagesList().add(file);
			file.setLinked(true);
		}
	}
	
	public void removeMetaFile(MetaFile file) {
		if(file != null) {
			this.getImagesList().remove(file);
			file.setLinked(false);
		}
	}
}