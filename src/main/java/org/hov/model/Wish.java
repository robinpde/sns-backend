package org.hov.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "wish")
public class Wish {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID wishid;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wish_item")
	private Item wishItem;

	@Column(name = "added_timestamp")
	@CreationTimestamp
	private Date addedTimestamp;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "linked_user")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UUID getWishid() {
		return wishid;
	}

	public void setWishid(UUID wishid) {
		this.wishid = wishid;
	}

	public Item getWishItem() {
		return wishItem;
	}

	public void setWishItem(Item wishItem) {
		this.wishItem = wishItem;
	}

	public Date getAddedTimestamp() {
		return addedTimestamp;
	}

	public void setAddedTimestamp(Date addedTimestamp) {
		this.addedTimestamp = addedTimestamp;
	}
}
