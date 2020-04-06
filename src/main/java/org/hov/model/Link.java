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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hov.enums.LinkType;

@Entity
@Table(name = "links")
public class Link {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID linkKey;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "linked_user")
	private User user;

	@Column(name = "link_name")
	@NotNull
	@Enumerated(EnumType.STRING)
	private LinkType linkType;

	@Column(name = "link_value")
	@NotBlank(message = "SNSERR000001")											//Cannot Be Empty
	private String linkValue;

	@Column(name = "link_code")
	@NotBlank(message = "SNSERR000001")											//Cannot Be Empty
	private String linkCode;
	
	@NotNull
	private boolean expired;

	public UUID getLinkKey() {
		return linkKey;
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

	public String getLinkCode() {
		return linkCode;
	}

	public void setLinkCode(String linkCode) {
		this.linkCode = linkCode;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}
}