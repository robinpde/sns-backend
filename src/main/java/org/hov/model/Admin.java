package org.hov.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hov.annotation.SNSEmailFormat;
import org.hov.enums.AdminType;

@Entity
@Table(name = "administrators")
public class Admin
{
	@Id						
	//@UniqueElements(message = "SNSERR000004")									//Already Exists
	private String adminid;														//Employee Id,Not auto generated
	
	@Column(unique = true)
	@SNSEmailFormat
	private String email;
	
	@Column(name = "admin_type")
	@Enumerated(EnumType.STRING)
	private AdminType adminType;
	
	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@OneToOne
	@JoinColumn(name = "picture_meta_file")
	private MetaFile pictureMetaFile;
	
	private boolean active;
	
	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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