package org.hov.template;

import org.hov.enums.EmailType;

public class EmailText {	
	public static final String PARAM_SITE_NAME = "Shop'N'Scroll";
	public static final String PARAM_SITE_LOGO = "http://xyz.png";

	/* CONSTANTS STRINGS FOR REPLACING */
	public static final String PARAM_USER_NAME = "PARAM_USER_NAME";
	public static final String PARAM_ORDER_NAME = "PARAM_ORDER_NAME";
	public static final String PARAM_ORDER_AMOUNT = "PARAM_ORDER_AMOUNT";
	public static final String PARAM_ORDER_DATE = "PARAM_ORDER_DATE";
	public static final String PARAM_CONTACT_NO = "PARAM_CONTACT_NO";
	public static final String PARAM_OTP_CODE = "PARAM_OTP_CODE";
	public static final String PARAM_URL_LINK = "PARAM_URL_LINK";
	
	/* WRITE HTML DESIGN */
	public static final String HTML_HEADER ="<html>" +
											"<head><style> .body{background:red} </style></head>" +
											"<body><div>";
	
	public static final String HTML_FOOTER ="</div><br>"+
											"<div> Click this button to proceed" + 
											"<a href='PARAM_URL_LINK'><button>Continue</a></button>" +
											"</div></body></html>";
	
	public static String[] subject=new String[20];
	public static String[] body=new String[20];
	
	static {
		/* SUBJECT['LOCALE_EN' , 'EMAIL_TYPE'] */
		subject[0] = "Email Verification Link from " + PARAM_SITE_NAME;
		subject[1] = "Email Change Link from " + PARAM_SITE_NAME;
		subject[2] = "Password Change Link from " + PARAM_SITE_NAME;
		subject[3] = "Payment Pending for Order: " + PARAM_ORDER_NAME;
		subject[4] = "Payment Completed for Order: " + PARAM_ORDER_NAME;
		subject[5] = "Packed - Order: " + PARAM_ORDER_NAME;
		subject[6] = "Dispatched - Order: " + PARAM_ORDER_NAME;
		subject[7] = "Order: " + PARAM_ORDER_NAME + " had been Cancelled!";
		subject[8] = "Order: " + PARAM_ORDER_NAME + " to be delivered on " + PARAM_ORDER_DATE;
		subject[9] = "Order: " + PARAM_ORDER_NAME + " had been Delivered!";
		subject[10]= "Order: " + PARAM_ORDER_NAME + ",will be picked on " + PARAM_ORDER_DATE;
		subject[11]= "Order: " + PARAM_ORDER_NAME + ",had been Returned!";
		subject[12]= "Order: " + PARAM_ORDER_NAME + ",had been Refunded!";
		subject[13]= "Promotion for Product: " + PARAM_ORDER_NAME + ", Activated!";
		subject[14]= "New Order! for Product: " + PARAM_ORDER_NAME;
		subject[15]= "Order Cancelled! for Product: " + PARAM_ORDER_NAME;
		subject[16]= "Pickup for Order of Product: " + PARAM_ORDER_NAME + ",had been scheduled on" + PARAM_ORDER_DATE;
		subject[17]= "Drop for Returned Product: " + PARAM_ORDER_NAME + ",had been scheduled on" + PARAM_ORDER_DATE;
		subject[18]= "Payment for Product: " + PARAM_ORDER_NAME + ",had been transferred!";
		
		/* BODY[ 'LOCALE_EN' , 'EMAIL_TYPE'] */
		body[0] ="";
		body[1] ="";
		body[2] ="";
		body[3] ="";
		body[4] ="";
		body[5] ="";
		body[6] ="";
		body[7] ="";
		body[8] ="";
		body[9] ="";
		body[10]="";
		body[11]="";
		body[13]="";
		body[14]="";
		body[15]="";
		body[16]="";
		body[17]="";
		body[18]="";   
	}
	
	public String getSubject(EmailType etyp) {
		return subject[etyp.ordinal()];
	}
	
	public String getBody(EmailType etyp) {
		return HTML_HEADER + body[etyp.ordinal()] + HTML_FOOTER;
	}
}