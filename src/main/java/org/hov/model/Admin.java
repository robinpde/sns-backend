package org.hov.model;

import java.net.URL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.UniqueElements;
import org.hov.enums.AdminType;

@Entity
@Table(name = "administrator")
public class Admin
{
	@Id						
	@UniqueElements(message = "SNSERR000004")									//Already Exists
	@NotNull(message = "SNSERR000001")											//Cannot Be Empty
	private String adminId;														//Employee Id,Not auto generated
	
	@Column(unique = true)
	@NotNull(message = "SNSERR000001")											//Cannot Be Empty
	@Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)"	  //As per RFC 5322 Standards
			        + "*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f"
			        + "]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0"
			        + "-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]"
			        + "|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-"
			        + "9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x2"
			        + "1-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", 
			  message="SNSERR000002")											//Invalid Email
	private String email;
	
	@Column(name = "admin_type")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "SNSERR000001")											//Cannot Be Empty
	private AdminType adminType;
	
	@NotBlank(message = "SNSERR000001")											//Cannot Be Empty
	//@Pattern(regexp = "", 
	//		   message = "SNSERR000003")										//Invalid Password Format
	private String password;

	@Column(name = "first_name")
	@NotBlank(message = "SNSERR000001")											//Cannot Be Empty
	private String firstName;

	@Column(name = "last_name")
	@NotBlank(message = "SNSERR000001")											//Cannot Be Empty
	private String lastName;

	@Column(name = "avatar_url")
	private URL avatar;
	
	@NotNull
	private boolean suspended;

	public URL getAvatarURL() {
		return avatar;
	}

	public String getAdminId() {
		return adminId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public AdminType getAdminType() {
		return adminType;
	}

	public void setAdminType(AdminType adminType) {
		this.adminType = adminType;
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAvatarURL(URL avatarURL) {
		this.avatar = avatarURL;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
}