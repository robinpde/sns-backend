package org.hov.template;

import org.hov.enums.SMSType;

public class SMSText {
	/* CONSTANTS STRINGS FOR REPLACING */
	public static final String PARAM_SITE_NAME = "Shop'N'Scroll";
	public static final String PARAM_USER_NAME = "PARAM_USER_NAME";
	public static final String PARAM_ORDER_NAME = "PARAM_ORDER_NAME";
	public static final String PARAM_ORDER_AMOUNT = "PARAM_ORDER_AMOUNT";
	public static final String PARAM_ORDER_DATE = "PARAM_ORDER_DATE";
	public static final String PARAM_CONTACT_NO = "PARAM_CONTACT_NO";
	public static final String PARAM_OTP_CODE = "PARAM_OTP_CODE";
	public static final String PARAM_URL_LINK = "PARAM_URL_LINK";

	public static final String FOOTER_NOTICE = "\n\n" +"For security reasons never share your OTP with anyone.";
	
	public static String[] text = new String[20];
	
	static {
		/* text['EMAIL_TYPE'] */
		text[0] = "Your " + PARAM_SITE_NAME + " OTP is " + PARAM_OTP_CODE;
		text[1] = "Email Change Link from " + PARAM_SITE_NAME;
		text[2] = "Password Change Link from " + PARAM_SITE_NAME;
		text[3] = "Payment Pending for Order: " + PARAM_ORDER_NAME;
		text[4] = "Payment Completed for Order: " + PARAM_ORDER_NAME;
		text[5] = "Packed - Order: " + PARAM_ORDER_NAME;
		text[6] = "Dispatched - Order: " + PARAM_ORDER_NAME;
		text[7] = "Order: " + PARAM_ORDER_NAME + " had been Cancelled.";
		text[8] = "Order: " + PARAM_ORDER_NAME + " to be delivered on " + PARAM_ORDER_DATE;
		text[9] = "Order: " + PARAM_ORDER_NAME + " had been Delivered.";
		text[10]= "Order: " + PARAM_ORDER_NAME + " will be picked on " + PARAM_ORDER_DATE;
		text[11]= "Order: " + PARAM_ORDER_NAME + " had been Returned. Refund has been initiated.";
		text[12]= "Order: " + PARAM_ORDER_NAME + " had been Refunded.";
		text[13]= "Promotion for Product: " + PARAM_ORDER_NAME + ", Activated!";
		text[14]= "Attention!! New Order for Product: " + PARAM_ORDER_NAME + "has been Placed.";
		text[15]= "Order Cancelled! for Product: " + PARAM_ORDER_NAME;
		text[16]= "Pickup for Order of Product: " + PARAM_ORDER_NAME + " had been scheduled on" + PARAM_ORDER_DATE;
		text[17]= "Drop for Returned Product: " + PARAM_ORDER_NAME + " had been scheduled on" + PARAM_ORDER_DATE;
		text[18]= "Payment for Product: " + PARAM_ORDER_NAME + " had been transferred!";
	}
	
	public String getText(SMSType styp) {
		return text[styp.ordinal()] + FOOTER_NOTICE;
	}
}
