package org.hov.model;

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
	
	@Column(unique = true)
	private String email;

	@Column(name = "email_veriified")
	private boolean emailVerified;

	@Column(unique = true)
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
	
	@Enumerated(EnumType.ORDINAL)
	private Gender gender;
	
	@Enumerated(EnumType.ORDINAL)
	private UserType userType;

	@Column(name = "dark_mode")
	private boolean darkMode;

	@Column(name = "silent_mode")
	private boolean silentMode;

	@Enumerated(EnumType.ORDINAL)
	private Locales localization;
	
	@OneToOne
	@JoinColumn(name = "picture_meta_file")
	private MetaFile pictureMetaFile;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "linked_vendor")
	private Vendor linkedVendor;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "wish_item_list")
	private List<Item> wishList = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Address> addressList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<OTPLink> otpLinkList = new ArrayList<>();
	
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
	
	public Vendor getLinkedVendor() {
		return linkedVendor;
	}

	public void setLinkedVendor(Vendor linkedVendor) {
		this.linkedVendor = linkedVendor;
	}

	/* LINKS-LIST HELPER FUNCTIONS */
	public List<OTPLink> getLinksList() {
		return otpLinkList;
	}
	
	public void addLink(OTPLink link) {
		if(link != null) {
			link.setUser(this);
			this.getLinksList().add(link);
		}
	}
	
	public void removeLink(OTPLink link) {
		if(link != null) {
			link.setUser(null);
			this.getLinksList().remove(link);
		}
	}

	/* ADDRESS LIST HELPER FUNCTIONS */
	public List<Address> getAddressList() {
		return addressList;
	}
	
	public void addAddress(Address address) {
		if(address != null) {
			address.setUser(this);
			this.getAddressList().add(address);
		}
	}
	
	public void removeAddress(Address address) {
		if(address != null) {
			address.setUser(null);
			this.getAddressList().remove(address);
		}
	}
	
	/* ORDERLIST HELPER FUNCTIONS */
	public List<Order> getOrderList() {
		return orderList;
	}

	public void addOrder(Order order) {
		if(order != null) {
			order.setUser(this);
			this.getOrderList().add(order);
		}
	}
	
	public void removeOrder(Order order) {
		if(order != null) {
			order.setUser(null);
			this.getOrderList().remove(order);
		}
	}

	/* WISHLIST HELPER FUNCTIONS */
	public List<Item> getWishList() {
		return wishList;
	}
	
	public void addWishItem(Item item) {
		if(item != null) {
			this.getWishList().add(item);
		}
	}
	
	public void removeWishItem(Item item) {
		if(item != null) {
			this.getWishList().remove(item);
		}
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