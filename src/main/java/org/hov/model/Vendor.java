package org.hov.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.hov.enums.ShiftHours;
import org.hov.enums.VendorType;

@Entity
@Table(name = "vendors")
public class Vendor {
	@Id
	@GeneratedValue
	private UUID vendorId;

	@Column(name = "vendor_name")
	@NotBlank(message = "SNSERR000001")											//Cannot Be Empty
	private String vendorName;
	
	@Column(name = "vendor_email")
	@NotBlank(message = "SNSERR000001")											//Cannot Be Empty
	private String vendorEmail;
	
	@Column(name = "vendor_phone")
	@NotBlank(message = "SNSERR000001")											//Cannot Be Empty
	private String vendorPhone;

	@Column(name = "vendor_type")
	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private VendorType vendorType;

	@Column(name = "vendor_shift")
	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private ShiftHours vendorShift;

	@Column(name = "response_days")
	@NotBlank(message = "SNSERR000001")											//Cannot Be Empty
	@Range(min=0, max=15, message = "SNSERR000006")								//Invalid Value
	private int responseDays;
	
	@OneToOne(mappedBy = "vendor")
	private User user;
	
	@Column(name = "items_list")
	@OneToMany(cascade = CascadeType.ALL,
			   fetch = FetchType.LAZY,
			   mappedBy = "vendor",
			   orphanRemoval = true)
	private List<Item> itemsList = new ArrayList<>();

	@NotNull
	private boolean blocked;

	@Column(name = "blocked_reason")
	@NotNull
	private String blockedReason;

	public UUID getVendorId() {
		return vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	public String getVendorPhone() {
		return vendorPhone;
	}

	public void setVendorPhone(String vendorPhone) {
		this.vendorPhone = vendorPhone;
	}

	public VendorType getVendorType() {
		return vendorType;
	}

	public void setVendorType(VendorType vendorType) {
		this.vendorType = vendorType;
	}

	public ShiftHours getVendorShift() {
		return vendorShift;
	}

	public void setVendorShift(ShiftHours vendorShift) {
		this.vendorShift = vendorShift;
	}

	public int getResponseDays() {
		return responseDays;
	}

	public void setResponseDays(int responseDays) {
		this.responseDays = responseDays;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public String getBlockedReason() {
		return blockedReason;
	}

	public void setBlockedReason(String blockedReason) {
		this.blockedReason = blockedReason;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Item> getItemsList() {
		return itemsList;
	}

	public void addItem(Item item) {
		if(item != null) {
			this.getItemsList().add(item);
		}
	}
	
	public void removeItem(Item item) {
		if(item != null) {
			item.setVendor(null);
			this.getItemsList().remove(item);
		}
	}
}