package org.hov.template;

import org.hov.enums.Locales;
import org.hov.enums.EmailType;

public class EmailText {	
	/* CONSTANTS STRINGS FOR REPLACING */
	public static final String PARAM_SITE_NAME = "PARAM_SITE_NAME";
	public static final String PARAM_SITE_LOGO = "PARAM_SITE_LOGO";
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
	
	public static String[][] subject=new String[3][20];
	public static String[][] body=new String[3][20];
	
	static {
		/* SUBJECT['LOCALE_EN' , 'EMAIL_TYPE'] */
		subject[0][0] = "Email Verification Link from " + PARAM_SITE_NAME;
		subject[0][1] = "Email Change Link from " + PARAM_SITE_NAME;
		subject[0][2] = "Password Change Link from " + PARAM_SITE_NAME;
		subject[0][3] = "Payment Pending for Order: " + PARAM_ORDER_NAME;
		subject[0][4] = "Payment Completed for Order: " + PARAM_ORDER_NAME;
		subject[0][5] = "Packed - Order: " + PARAM_ORDER_NAME;
		subject[0][6] = "Dispatched - Order: " + PARAM_ORDER_NAME;
		subject[0][7] = "Order: " + PARAM_ORDER_NAME + " had been Cancelled!";
		subject[0][8] = "Order: " + PARAM_ORDER_NAME + " to be delivered on " + PARAM_ORDER_DATE;
		subject[0][9] = "Order: " + PARAM_ORDER_NAME + " had been Delivered!";
		subject[0][10]= "Order: " + PARAM_ORDER_NAME + ",will be picked on " + PARAM_ORDER_DATE;
		subject[0][11]= "Order: " + PARAM_ORDER_NAME + ",had been Returned!";
		subject[0][12]= "Order: " + PARAM_ORDER_NAME + ",had been Refunded!";
		subject[0][13]= "Promotion for Product: " + PARAM_ORDER_NAME + ", Activated!";
		subject[0][14]= "New Order! for Product: " + PARAM_ORDER_NAME;
		subject[0][15]= "Order Cancelled! for Product: " + PARAM_ORDER_NAME;
		subject[0][16]= "Pickup for Order of Product: " + PARAM_ORDER_NAME + ",had been scheduled on" + PARAM_ORDER_DATE;
		subject[0][17]= "Drop for Returned Product: " + PARAM_ORDER_NAME + ",had been scheduled on" + PARAM_ORDER_DATE;
		subject[0][18]= "Payment for Product: " + PARAM_ORDER_NAME + ",had been transferred!";
		
		/* SUBJECT['LOCALE_HI' , 'EMAIL_TYPE'] */
		subject[1][0] = "Email Verification Link from " + PARAM_SITE_NAME;
		subject[1][1] = "Email Change Link from " + PARAM_SITE_NAME;
		subject[1][2] = "Password Change Link from " + PARAM_SITE_NAME;
		subject[1][3] = "Payment Pending for Order: " + PARAM_ORDER_NAME;
		subject[1][4] = "Payment Completed for Order: " + PARAM_ORDER_NAME;
		subject[1][5] = "Packed - Order: " + PARAM_ORDER_NAME;
		subject[1][6] = "Dispatched - Order: " + PARAM_ORDER_NAME;
		subject[1][7] = "Order: " + PARAM_ORDER_NAME + " had been Cancelled!";
		subject[1][8] = "Order: " + PARAM_ORDER_NAME + " to be delivered on " + PARAM_ORDER_DATE;
		subject[1][9] = "Order: " + PARAM_ORDER_NAME + " had been Delivered!";
		subject[1][10]= "Order: " + PARAM_ORDER_NAME + ",will be picked on " + PARAM_ORDER_DATE;
		subject[1][11]= "Order: " + PARAM_ORDER_NAME + ",had been Returned!";
		subject[1][12]= "Order: " + PARAM_ORDER_NAME + ",had been Refunded!";
		subject[1][13]= "Promotion for Product: " + PARAM_ORDER_NAME + ", Activated!";
		subject[1][14]= "New Order! for Product: " + PARAM_ORDER_NAME;
		subject[1][15]= "Order Cancelled! for Product: " + PARAM_ORDER_NAME;
		subject[1][16]= "Pickup for Order of Product: " + PARAM_ORDER_NAME + ",had been scheduled on" + PARAM_ORDER_DATE;
		subject[1][17]= "Drop for Returned Product: " + PARAM_ORDER_NAME + ",had been scheduled on" + PARAM_ORDER_DATE;
		subject[1][18]= "Payment for Product: " + PARAM_ORDER_NAME + ",had been transferred!";
		
		/* SUBJECT['LOCALE_TA' , 'EMAIL_TYPE'] */
		subject[2][0] = PARAM_SITE_NAME + "'இலிருந்து மின்னஞ்சல் சரிபார்ப்பு இணைய முகப்பு உள்ளே.";
		subject[2][1] = PARAM_SITE_NAME + "'இலிருந்து மின்னஞ்சல் மாற்ற இணைய முகப்பு உள்ளே.";
		subject[2][2] = PARAM_SITE_NAME + "'இலிருந்து கடவுச்சொல் மாற்ற இணைய முகப்பு உள்ளே.";
		subject[2][3] = PARAM_ORDER_NAME + " ஆர்டருக்கான கட்டணம் காத்திருக்கிறது.";
		subject[2][4] = PARAM_ORDER_NAME + " ஆர்டருக்கான கட்டணம் முடிந்தது.";
		subject[2][5] = "ஆர்டர்: " + PARAM_ORDER_NAME + ",தயார் செய்யப்பட்டது!";
		subject[2][6] = "ஆர்டர்: " + PARAM_ORDER_NAME + ",கிடங்கிலிருந்து அனுப்பப்பட்டது!";
		subject[2][7] = "ஆர்டர்: " + PARAM_ORDER_NAME + ",ரத்து செய்யப்பட்டது!";
		subject[2][8] = "ஆர்டர்: " + PARAM_ORDER_NAME + "," + PARAM_ORDER_DATE + "'ஆம் நாளில்  டெலிவரி செய்யப்படும்!";
		subject[2][9] = "ஆர்டர்: " + PARAM_ORDER_NAME + ",டெலிவரி செய்யப்பட்டது!";
		subject[2][10]= "ஆர்டர்: " + PARAM_ORDER_NAME + "," + PARAM_ORDER_DATE + "'ஆம் நாளில்  திரும்பப் பெறப்படும்!";
		subject[2][11]= "ஆர்டர்: " + PARAM_ORDER_NAME + ",திருப்பி அனுப்பப்பட்டது!";
		subject[2][12]= "ஆர்டர்: " + PARAM_ORDER_NAME + "'க்கான தொகை திருப்பி அனுப்பப்பட்டுள்ளது!";
		subject[2][13]= PARAM_ORDER_NAME + "'க்கான விளம்பரம் தயாராக உள்ளது!";
		subject[0][14]= "புதிய ஆர்டர்! " + PARAM_ORDER_NAME + "'க்காக";
		subject[0][15]= PARAM_ORDER_NAME + "'க்கான  ஆர்டர் ரத்து செய்யப்பட்டது!";
		subject[0][16]= PARAM_ORDER_NAME + "," + PARAM_ORDER_DATE + "'ஆம் நாளில்  எடுக்கப்படும்!";
		subject[0][17]= PARAM_ORDER_NAME + "," + PARAM_ORDER_DATE + "'ஆம் நாளில்  திருப்பித் தரப்படும்!";
		subject[0][18]= PARAM_ORDER_NAME + "க்கான தொகை  அனுப்பப்பட்டுள்ளது!";
		
		/* BODY[ 'LOCALE_EN' , 'EMAIL_TYPE'] */
		body[0][0] ="";
		body[0][1] ="";
		body[0][2] ="";
		body[0][3] ="";
		body[0][4] ="";
		body[0][5] ="";
		body[0][6] ="";
		body[0][7] ="";
		body[0][8] ="";
		body[0][9] ="";
		body[0][10]="";
		body[0][11]="";
		body[0][13]="";
		body[0][14]="";
		body[0][15]="";
		body[0][16]="";
		body[0][17]="";
		body[0][18]=""; 
		
		/* BODY['LOCALE_HI' , 'EMAIL_TYPE'] */
		body[1][0] ="";
		body[1][1] ="";
		body[1][2] ="";
		body[1][3] ="";
		body[1][4] ="";
		body[1][5] ="";
		body[1][6] ="";
		body[1][7] ="";
		body[1][8] ="";
		body[1][9] ="";
		body[1][10]="";
		body[1][11]="";
		body[1][13]="";
		body[1][14]="";
		body[1][15]="";
		body[1][16]="";
		body[1][17]="";
		body[1][18]=""; 
		
		/* BODY['LOCALE_TA' , 'EMAIL_TYPE'] */
		body[2][0] ="";
		body[2][1] ="";
		body[2][2] ="";
		body[2][3] ="";
		body[2][4] ="";
		body[2][5] ="";
		body[2][6] ="";
		body[2][7] ="";
		body[2][8] ="";
		body[2][9] ="";
		body[2][10]="";
		body[2][11]="";
		body[2][13]="";
		body[2][14]="";
		body[2][15]="";
		body[2][16]="";
		body[2][17]="";
		body[2][18]=""; 	  
	}
	
	public String getSubject(Locales loc, EmailType etyp) {
		return subject[loc.ordinal()][etyp.ordinal()];
	}
	
	public String getBody(Locales loc, EmailType etyp) {
		return HTML_HEADER + body[loc.ordinal()][etyp.ordinal()] + HTML_FOOTER;
	}
}