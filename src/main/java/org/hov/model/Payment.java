package org.hov.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hov.enums.PaymentMode;
import org.hov.enums.PaymentStatus;

@Entity
@Table(name="payments")
public class Payment {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID paymentid;
	
	@Column(name = "payment_mode")
	@Enumerated(EnumType.ORDINAL)
	private PaymentMode paymentMode;

	@Column(name = "payment_portal")
	private String PaymentPortal;

	@Column(name = "payment_status")
	@Enumerated(EnumType.ORDINAL)
	private PaymentStatus paymentStatus;

	@Column(name = "payment_log")
	private String paymentLog;
	
	public UUID getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(UUID paymentid) {
		this.paymentid = paymentid;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentPortal() {
		return PaymentPortal;
	}

	public void setPaymentPortal(String paymentPortal) {
		PaymentPortal = paymentPortal;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentLog() {
		return paymentLog;
	}

	public void setPaymentLog(String paymentLog) {
		this.paymentLog = paymentLog;
	}
}