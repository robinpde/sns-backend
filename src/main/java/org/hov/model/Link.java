package org.hov.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hov.enums.LinkType;

@Entity
@Table(name = "links")
public class Link {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID linkkey;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "linked_user")
	private User user;

	@Column(name = "link_name")
	@Enumerated(EnumType.STRING)
	private LinkType linkType;

	@Column(name = "link_value")
	private String linkValue;

	@Column(name = "link_code")
	private String verificationCode;

	public UUID getLinkkey() {
		return linkkey;
	}

	public void setLinkkey(UUID linkkey) {
		this.linkkey = linkkey;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LinkType getLinkType() {
		return linkType;
	}

	public void setLinkType(LinkType linkType) {
		this.linkType = linkType;
	}

	public String getLinkValue() {
		return linkValue;
	}

	public void setLinkValue(String linkValue) {
		this.linkValue = linkValue;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
}