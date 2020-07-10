package org.hov.template;

import org.hov.enums.Locales;
import org.hov.enums.SMSType;

public class SMSText {
	/* CONSTANTS STRINGS FOR REPLACING */
	public static final String PARAM_SITE_NAME = "PARAM_SITE_NAME";
	public static final String PARAM_USER_NAME = "PARAM_USER_NAME";
	public static final String PARAM_ORDER_NAME = "PARAM_ORDER_NAME";
	public static final String PARAM_ORDER_AMOUNT = "PARAM_ORDER_AMOUNT";
	public static final String PARAM_ORDER_DATE = "PARAM_ORDER_DATE";
	public static final String PARAM_CONTACT_NO = "PARAM_CONTACT_NO";
	public static final String PARAM_OTP_CODE = "PARAM_OTP_CODE";
	public static final String PARAM_URL_LINK = "PARAM_URL_LINK";

	public static final String FOOTER_NOTICE = "\n\n" +
			"For security reasons never share your OTP Code and OTP link with anyone.";
	
	public static String[][] text = new String[3][20];
	
	static {
		/* text['LOCALE_EN' , 'EMAIL_TYPE'] */
		text[0][0] = "Your " + PARAM_SITE_NAME + " OTP is " + PARAM_OTP_CODE + 
				"\n\n" + "Click this link and enter the OTP to complete the verification:  https://test.xyzjidfefsa.com/" + 
				PARAM_URL_LINK;
		text[0][1] = "Email Change Link from " + PARAM_SITE_NAME;
		text[0][2] = "Password Change Link from " + PARAM_SITE_NAME;
		text[0][3] = "Payment Pending for Order: " + PARAM_ORDER_NAME;
		text[0][4] = "Payment Completed for Order: " + PARAM_ORDER_NAME;
		text[0][5] = "Packed - Order: " + PARAM_ORDER_NAME;
		text[0][6] = "Dispatched - Order: " + PARAM_ORDER_NAME;
		text[0][7] = "Order: " + PARAM_ORDER_NAME + " had been Cancelled!";
		text[0][8] = "Order: " + PARAM_ORDER_NAME + " to be delivered on " + PARAM_ORDER_DATE;
		text[0][9] = "Order: " + PARAM_ORDER_NAME + " had been Delivered!";
		text[0][10]= "Order: " + PARAM_ORDER_NAME + ",will be picked on " + PARAM_ORDER_DATE;
		text[0][11]= "Order: " + PARAM_ORDER_NAME + ",had been Returned!";
		text[0][12]= "Order: " + PARAM_ORDER_NAME + ",had been Refunded!";
		text[0][13]= "Promotion for Product: " + PARAM_ORDER_NAME + ", Activated!";
		text[0][14]= "New Order! for Product: " + PARAM_ORDER_NAME;
		text[0][15]= "Order Cancelled! for Product: " + PARAM_ORDER_NAME;
		text[0][16]= "Pickup for Order of Product: " + PARAM_ORDER_NAME + ",had been scheduled on" + PARAM_ORDER_DATE;
		text[0][17]= "Drop for Returned Product: " + PARAM_ORDER_NAME + ",had been scheduled on" + PARAM_ORDER_DATE;
		text[0][18]= "Payment for Product: " + PARAM_ORDER_NAME + ",had been transferred!";
		
		/* text['LOCALE_HI' , 'EMAIL_TYPE'] */
		text[1][0] = "Email Verification Link from " + PARAM_SITE_NAME ;
		text[1][1] = "Email Change Link from " + PARAM_SITE_NAME;
		text[1][2] = "Password Change Link from " + PARAM_SITE_NAME;
		text[1][3] = "Payment Pending for Order: " + PARAM_ORDER_NAME;
		text[1][4] = "Payment Completed for Order: " + PARAM_ORDER_NAME;
		text[1][5] = "Packed - Order: " + PARAM_ORDER_NAME;
		text[1][6] = "Dispatched - Order: " + PARAM_ORDER_NAME;
		text[1][7] = "Order: " + PARAM_ORDER_NAME + " had been Cancelled!";
		text[1][8] = "Order: " + PARAM_ORDER_NAME + " to be delivered on " + PARAM_ORDER_DATE;
		text[1][9] = "Order: " + PARAM_ORDER_NAME + " had been Delivered!";
		text[1][10]= "Order: " + PARAM_ORDER_NAME + ",will be picked on " + PARAM_ORDER_DATE;
		text[1][11]= "Order: " + PARAM_ORDER_NAME + ",had been Returned!";
		text[1][12]= "Order: " + PARAM_ORDER_NAME + ",had been Refunded!";
		text[1][13]= "Promotion for Product: " + PARAM_ORDER_NAME + ", Activated!";
		text[1][14]= "New Order! for Product: " + PARAM_ORDER_NAME;
		text[1][15]= "Order Cancelled! for Product: " + PARAM_ORDER_NAME;
		text[1][16]= "Pickup for Order of Product: " + PARAM_ORDER_NAME + ",had been scheduled on" + PARAM_ORDER_DATE;
		text[1][17]= "Drop for Returned Product: " + PARAM_ORDER_NAME + ",had been scheduled on" + PARAM_ORDER_DATE;
		text[1][18]= "Payment for Product: " + PARAM_ORDER_NAME + ",had been transferred!";
		
		/* text['LOCALE_TA' , 'EMAIL_TYPE'] */
		text[2][0] = PARAM_SITE_NAME + "'இலிருந்து மின்னஞ்சல் சரிபார்ப்பு இணைய முகப்பு உள்ளே.";
		text[2][1] = PARAM_SITE_NAME + "'இலிருந்து மின்னஞ்சல் மாற்ற இணைய முகப்பு உள்ளே.";
		text[2][2] = PARAM_SITE_NAME + "'இலிருந்து கடவுச்சொல் மாற்ற இணைய முகப்பு உள்ளே.";
		text[2][3] = PARAM_ORDER_NAME + " ஆர்டருக்கான கட்டணம் காத்திருக்கிறது.";
		text[2][4] = PARAM_ORDER_NAME + " ஆர்டருக்கான கட்டணம் முடிந்தது.";
		text[2][5] = "ஆர்டர்: " + PARAM_ORDER_NAME + ",தயார் செய்யப்பட்டது!";
		text[2][6] = "ஆர்டர்: " + PARAM_ORDER_NAME + ",கிடங்கிலிருந்து அனுப்பப்பட்டது!";
		text[2][7] = "ஆர்டர்: " + PARAM_ORDER_NAME + ",ரத்து செய்யப்பட்டது!";
		text[2][8] = "ஆர்டர்: " + PARAM_ORDER_NAME + "," + PARAM_ORDER_DATE + "'ஆம் நாளில்  டெலிவரி செய்யப்படும்!";
		text[2][9] = "ஆர்டர்: " + PARAM_ORDER_NAME + ",டெலிவரி செய்யப்பட்டது!";
		text[2][10]= "ஆர்டர்: " + PARAM_ORDER_NAME + "," + PARAM_ORDER_DATE + "'ஆம் நாளில்  திரும்பப் பெறப்படும்!";
		text[2][11]= "ஆர்டர்: " + PARAM_ORDER_NAME + ",திருப்பி அனுப்பப்பட்டது!";
		text[2][12]= "ஆர்டர்: " + PARAM_ORDER_NAME + "'க்கான தொகை திருப்பி அனுப்பப்பட்டுள்ளது!";
		text[2][13]= PARAM_ORDER_NAME + "'க்கான விளம்பரம் தயாராக உள்ளது!";
		text[0][14]= "புதிய ஆர்டர்! " + PARAM_ORDER_NAME + "'க்காக";
		text[0][15]= PARAM_ORDER_NAME + "'க்கான  ஆர்டர் ரத்து செய்யப்பட்டது!";
		text[0][16]= PARAM_ORDER_NAME + "," + PARAM_ORDER_DATE + "'ஆம் நாளில்  எடுக்கப்படும்!";
		text[0][17]= PARAM_ORDER_NAME + "," + PARAM_ORDER_DATE + "'ஆம் நாளில்  திருப்பித் தரப்படும்!";
		text[0][18]= PARAM_ORDER_NAME + "க்கான தொகை  அனுப்பப்பட்டுள்ளது!";
	}
	
	public String getText(Locales loc, SMSType styp) {
		return text[loc.ordinal()][styp.ordinal()] + FOOTER_NOTICE;
	}
}
