package org.hov.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
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
@Table(name = "item")
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

	@Column(name = "vendor_stock")
	private int vendorStock;
	
	@Column(name = "customer_stock")
	private int customerStock;
	
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
	@JoinColumn(name = "image_list")
	private List<MetaFile> imageList = new ArrayList<>();
	
	@Column(name = "promotions_list")
	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Promotion> promotionList = new ArrayList<>();
	
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

	public int getVendorStock() {
		return vendorStock;
	}

	public void setVendorStock(int vendorStock) {
		this.vendorStock = vendorStock;
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

	/* IMAGES LIST HELPER FUNCTIONS */
	public List<MetaFile> getImageList() {
		return imageList;
	}
	
	public void addMetaFile(MetaFile file) {
		if(file != null) {
			this.getImageList().add(file);
			file.setLinked(true);
		}
	}
	
	public void removeMetaFile(MetaFile file) {
		if(file != null) {
			this.getImageList().remove(file);
			file.setLinked(false);
		}
	}
	
	/* IMAGESLIST SETTER IS INTENTIONAL */
	/* ITS FOR SAVING SHUFFLED/SORTED LIST */
	public void setImageList(List<MetaFile> imagesList) {
		this.imageList = imagesList;
	}
}