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

import org.hibernate.annotations.Type;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID addressid;
	
	@Column(name = "address_name")
	private String addressName;

	@Column(name = "address_text")
	private String addressText;
	
	@Column(name = "landmark_text")
	private String landmark;
	
	private String street;

	private String city;

	private String state;

	private String country;

	@Column(name = "postal_number")
	private String pin;

	@Column(name = "phone_number")
	private String phone;

	@Column(name = "default_address")
	private boolean defaultAddress;
	
	/* SELLER SPECIFIC COLUMNS */
	@Column(name = "warehouse_name")
	private String warehouseName;
	
	@Column(name = "coordinates_x")
	private long coordinatesX;

	@Column(name = "coordinates_y")
	private long coordinatesY;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "linked_user")
	private User user;
	
	public UUID getAddressid() {
		return addressid;
	}

	public void setAddressid(UUID addressid) {
		this.addressid = addressid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAddressText() {
		return addressText;
	}

	public void setAddressText(String addressText) {
		this.addressText = addressText;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(boolean defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public long getCoordinatesX() {
		return coordinatesX;
	}

	public void setCoordinatesX(long coordinatesX) {
		this.coordinatesX = coordinatesX;
	}

	public long getCoordinatesY() {
		return coordinatesY;
	}

	public void setCoordinatesY(long coordinatesY) {
		this.coordinatesY = coordinatesY;
	}
}