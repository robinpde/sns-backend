package org.hov.model;

import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.hov.enums.OrderStatus;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID orderid;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_item")
	private Item orderItem;

	@Column
	private int quantity;

	@Column(name = "order_status")
	@Enumerated(EnumType.ORDINAL)
	private OrderStatus orderStatus;

	@Column(name = "added_timestamp")
	@CreationTimestamp
	private Date createdTimestamp;

	@Column(name = "updated_timestamp")
	@UpdateTimestamp
	private Date updatedTimestamp;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "linked_user")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_link")
	private PaymentLink paymentLink;

	public UUID getOrderid() {
		return orderid;
	}

	public void setOrderid(UUID orderid) {
		this.orderid = orderid;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

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

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public Date getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(Date updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	public Item getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(Item orderItem) {
		this.orderItem = orderItem;
	}

	public PaymentLink getPaymentLink() {
		return paymentLink;
	}

	public void setPaymentLink(PaymentLink paymentLink) {
		this.paymentLink = paymentLink;
	}
}