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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hov.annotation.SNSContactFormat;
import org.hov.annotation.SNSCountryCodeFormat;
import org.hov.annotation.SNSEmailFormat;
import org.hov.annotation.SNSPasswordFormat;
import org.hov.enums.Gender;
import org.hov.enums.Locales;
import org.hov.enums.UserType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID userid;
	
	@Column
	@SNSEmailFormat
	private String email;

	@Column(name = "email_veriified")
	@NotNull
	private boolean emailVerified;

	@Column
	@NotEmpty(message = " is mandatory")
	@SNSCountryCodeFormat
	private String countryCode;
	
	@Column
	@SNSContactFormat
	private String phone;

	@Column(name = "phone_veriified")
	@NotNull
	private boolean phoneVerified;

	@NotEmpty
	@SNSPasswordFormat
	private String password;

	@Column(name = "first_name")
	@NotBlank(message = " cannot be blank")
	private String firstName;

	@Column(name = "last_name")
	@NotBlank(message = " cannot be blank")
	private String lastName;

	@Column(name = "date_of_birth")
	private Date dob;
	
	@Enumerated(EnumType.ORDINAL)
	private Gender gender;
	
	@Enumerated(EnumType.ORDINAL)
	private UserType userType;

	@Column(name = "dark_mode")
	@NotNull
	private boolean darkMode;

	@Column(name = "email_alert")
	@NotNull
	private boolean emailAlert;

	@Column(name = "phone_alert")
	@NotNull
	private boolean phoneAlert;
	
	@Enumerated(EnumType.ORDINAL)
	private Locales localization;
	
	@NotNull
	private boolean active;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Vendor vendor;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Address> addressList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<OTPLink> otpLinkList = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Wish> wishList = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Cart> cartList = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Order> orderList = new ArrayList<>();
	
	public UUID getUserid() {
		return userid;
	}
	
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
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

	public boolean hasEmailAlert() {
		return emailAlert;
	}

	public void setEmailAlert(boolean emailAlert) {
		this.emailAlert = emailAlert;
	}

	public boolean hasPhoneAlert() {
		return phoneAlert;
	}

	public void setPhoneAlert(boolean phoneAlert) {
		this.phoneAlert = phoneAlert;
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
	
	public Vendor getVendor() {
		return vendor;
	}

	public void setLinkedVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	/* ADDRESS LIST HELPER FUNCTIONS */
	@JsonIgnore
	public List<Address> getAddressList() {
		return addressList;
	}
	
	public void addAddress(Address address) {
		if(address != null) {
			this.getAddressList().add(address);
			address.setUser(this);
		}
	}
	
	public void removeAddress(Address address) {
		if(address != null) {
			address.setUser(null);
			this.getAddressList().remove(address);
		}
	}

	/* LINKS-LIST HELPER FUNCTIONS */
	@JsonIgnore
	public List<OTPLink> getLinksList() {
		return otpLinkList;
	}
	
	public void addLink(OTPLink link) {
		if(link != null) {
			this.getLinksList().add(link);
			link.setUser(this);
		}
	}
	
	public void removeLink(OTPLink link) {
		if(link != null) {
			this.getLinksList().remove(link);
			link.setUser(null);
		}
	}
	
	/* WISHLIST HELPER FUNCTIONS */
	@JsonIgnore
	public List<Wish> getWishList() {
		return wishList;
	}

	public void addToWish(Wish wish) {
		if(wish != null) {
			this.getWishList().add(wish);
			wish.setUser(this);
		}
	}
	
	public void removeFromWish(Wish wish) {
		if(wish != null) {
			this.getWishList().remove(wish);
			wish.setUser(null);
		}
	}
	
	/* CARTLIST HELPER FUNCTIONS */
	@JsonIgnore
	public List<Cart> getCartList() {
		return cartList;
	}

	public void addToCart(Cart cart) {
		if(cart != null) {
			this.getCartList().add(cart);
			cart.setUser(this);
		}
	}
	
	public void removeFromCart(Cart cart) {
		if(cart != null) {
			this.getCartList().remove(cart);
			cart.setUser(null);
		}
	}
	
	/* ORDERLIST HELPER FUNCTIONS */
	@JsonIgnore
	public List<Order> getOrderList() {
		return orderList;
	}

	public void addOrder(Order order) {
		if(order != null) {
			this.getOrderList().add(order);
			order.setUser(this);
		}
	}
	
	public void removeOrder(Order order) {
		if(order != null) {
			this.getOrderList().remove(order);
			order.setUser(null);
		}
	}
}