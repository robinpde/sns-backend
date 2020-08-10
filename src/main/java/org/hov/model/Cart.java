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
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID cartid;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cart_item")
	private Item cartItem;

	@Column
	private int quantity;

	@Column(name = "checked_out")
	private boolean checkedOut;

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public UUID getCartid() {
		return cartid;
	}

	public void setCartid(UUID cartid) {
		this.cartid = cartid;
	}

	public Item getCartItem() {
		return cartItem;
	}

	public void setCartItem(Item cartItem) {
		this.cartItem = cartItem;
	}

	public boolean isCheckedOut() {
		return checkedOut;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	public Date getAddedTimestamp() {
		return addedTimestamp;
	}

	public void setAddedTimestamp(Date addedTimestamp) {
		this.addedTimestamp = addedTimestamp;
	}
}
