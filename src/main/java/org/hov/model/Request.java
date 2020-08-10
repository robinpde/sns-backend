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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hov.enums.RequestStatus;
import org.hov.enums.RequestType;

@Entity
@Table(name = "request")
public class Request {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID requestid;
	
	@Column(name = "request_type")
	@Enumerated(EnumType.ORDINAL)
	private RequestType requestType; 

	@Column(name = "request_status")
	@Enumerated(EnumType.ORDINAL)
	private RequestStatus requestStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "linked_vendor")
	private Vendor vendor;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assigned_admin")
	private Admin admin;

	@Column(name = "request_title")
	private String requestTitle;

	@Column(name = "request_text")
	private String requestText;
	
	public UUID getRequestid() {
		return requestid;
	}

	public void setRequestid(UUID requestid) {
		this.requestid = requestid;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public RequestStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getRequestTitle() {
		return requestTitle;
	}

	public void setRequestTitle(String requestTitle) {
		this.requestTitle = requestTitle;
	}

	public String getRequestText() {
		return requestText;
	}

	public void setRequestText(String requestText) {
		this.requestText = requestText;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}