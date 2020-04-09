package org.hov.model;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hov.enums.Gender;
import org.hov.enums.Locales;
import org.hov.enums.UserType;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID userid;
	
	@Column
	private String email;

	@Column(name = "email_veriified")
	private boolean emailVerified;

	private String phone;

	@Column(name = "phone_veriified")
	private boolean phoneVerified;

	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "date_of_birth")
	private Date dob;
	
	@Column(name = "user_picture_url")
	private URL userPicture;
	
	@Enumerated(EnumType.ORDINAL)
	private Gender gender;
	
	@Enumerated(EnumType.ORDINAL)
	private UserType userType;

	@Column(name = "dark_mode")
	private boolean darkMode;

	@Column(name = "silent_mode")
	private boolean silentMode;

	@Column(name = "email_alert")
	private boolean emailAlert;

	@Enumerated(EnumType.ORDINAL)
	private Locales localization;

	//private List<UUID> wishList = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "vendorId")
	private Vendor vendor;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Address> addressList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Link> linksList = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Order> orderList = new ArrayList<>();
	
	private boolean active;

	public UUID getUserid() {
		return userid;
	}

	public void setUserid(UUID userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isPhoneVerified() {
		return phoneVerified;
	}

	public void setPhoneVerified(boolean phoneVerified) {
		this.phoneVerified = phoneVerified;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public URL getUserPicture() {
		return userPicture;
	}

	public void setUserPicture(URL userPicture) {
		this.userPicture = userPicture;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public boolean isDarkMode() {
		return darkMode;
	}

	public void setDarkMode(boolean darkMode) {
		this.darkMode = darkMode;
	}

	public boolean isSilentMode() {
		return silentMode;
	}

	public void setSilentMode(boolean silentMode) {
		this.silentMode = silentMode;
	}

	public boolean isEmailAlert() {
		return emailAlert;
	}

	public void setEmailAlert(boolean emailAlert) {
		this.emailAlert = emailAlert;
	}

	public Locales getLocalization() {
		return localization;
	}

	public void setLocalization(Locales localization) {
		this.localization = localization;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Address> getAddressList() {
		return addressList;
	}
	
	public void addAddress(Address address) {
		if(address != null) {
			this.getAddressList().add(address);
		}
	}
	
	public void removeAddress(Address address) {
		if(address != null) {
			address.setUser(null);
			this.getAddressList().remove(address);
		}
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public List<Link> getLinksList() {
		return linksList;
	}
	
	public void addLink(Link link) {
		if(link != null) {
			this.getLinksList().add(link);
		}
	}
	
	public void removeLink(Link link) {
		if(link != null) {
			link.setUser(null);
			this.getLinksList().remove(link);
		}
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void addOrder(Order order) {
		if(order != null) {
			this.getOrderList().add(order);
		}
	}
	
	public void remmoveOrder(Order order) {
		if(order != null) {
			order.setUser(null);
			this.getOrderList().remove(order);
		}
	}
}