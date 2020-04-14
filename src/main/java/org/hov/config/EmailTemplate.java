package org.hov.config;

import org.hov.enums.Locales;
import org.hov.enums.EmailType;

public class EmailTemplate {
	/* HTML DESIGN */
	public static final String HTML_HEADER = "<html><body>" +
	"<b>Email Design Test</b>";
	
	public static final String HTML_FOOTER = "</body></html>";
	
	/* CONSTANTS STRINGS FOR REPLACING */
	public static final String PARAM_LOGO_URL = "$ZLOGO_URL$";
	public static final String PARAM_USER_NAME = "$ZUSER_NAMEZ$";
	public static final String PARAM_ORDER_TEXT = "$ZORDER_TEXTZ$";
	public static final String PARAM_ORDER_AMOUNT = "$ZORDER_AMOUNTZ$";
	public static final String PARAM_VERIFICATION_CODE = "$ZVERIFICATION_CODEZ$";
	public static final String PARAM_HTTP_LINK = "$ZHTTP_LINKZ$";
	
	public static String subject[][];
	public static String body[][];
	
	static {
		/* SUBJECT['LOCALE_EN' , 'EMAIL_TYPE'] */
		subject[0][0] = "Email Verification Link from ShopNScroll";
		subject[0][1] = "Email Change Link from ShopNScroll";
		subject[0][2] = "Password Change Link from ShopNScroll";
		subject[0][3] = "Payment Pending for Order: " + PARAM_ORDER_TEXT;
		subject[0][4] = "Payment Completed for Order: " + PARAM_ORDER_TEXT;
		subject[0][5] = "Packed - Order: " + PARAM_ORDER_TEXT;
		subject[0][6] = "Dispatched - Order: " + PARAM_ORDER_TEXT;
		subject[0][7] = "Order: " + PARAM_ORDER_TEXT + " has been Cancelled!";
		subject[0][8] = "Out For Delivery - Order: " + PARAM_ORDER_TEXT;
		subject[0][9] = "Order: " + PARAM_ORDER_TEXT + " Delivered!";
		subject[0][10]= "Return for Order: " + PARAM_ORDER_TEXT + " Requested!";
		subject[0][11]= "Order: " + PARAM_ORDER_TEXT + " Returned!";
		subject[0][12]= "Order: " + PARAM_ORDER_TEXT + " Refunded!";
		subject[0][13]= "Promotion for Product: " + PARAM_ORDER_TEXT + "Activated!!";
		subject[0][14]= "Promotion for Product: " + PARAM_ORDER_TEXT + "Expiring";
		
		/* BODY[ 'LOCALE_EN' , 'EMAIL_TYPE'] */
		body[0][0] = HTML_HEADER + 
			      "" + 
			      HTML_FOOTER;
		body[0][1] = HTML_HEADER + 
			 	  "" + 
			 	  HTML_FOOTER;
		body[0][2] = HTML_HEADER + 
			 	  "" + 
			      HTML_FOOTER;
		body[0][3] = HTML_HEADER + 
			 	  "" + 
			 	  HTML_FOOTER;
		body[0][4] = HTML_HEADER + 
			 	  "" + 
			 	  HTML_FOOTER;
		body[0][5] = HTML_HEADER + 
			 	  "" + 
			 	  HTML_FOOTER;
		body[0][6] = HTML_HEADER + 
			 	  "" + 
			 	  HTML_FOOTER;
		body[0][7] = HTML_HEADER + 
			 	  "" + 
			 	  HTML_FOOTER;
		body[0][8]= HTML_HEADER + 
			 	  "" + 
			 	  HTML_FOOTER;
		body[0][9] = HTML_HEADER + 
			 	  "" + 
			 	  HTML_FOOTER;
		body[0][10]=HTML_HEADER + 
			 	  "" + 
			 	  HTML_FOOTER;
		body[0][11]= HTML_HEADER + 
				  "" + 
			 	  HTML_FOOTER;
		body[0][12]= HTML_HEADER + 
				  "" + 
			 	  HTML_FOOTER;
		body[0][13]=HTML_HEADER + 
			 	  "" + 
			 	  HTML_FOOTER;
		body[0][14]= HTML_HEADER + 
			 	  "" + 
			 	  HTML_FOOTER;
		
		/* SUBJECT['LOCALE_HI' , 'EMAIL_TYPE'] */
		subject[1][0] = "hindi text";
		subject[1][1] = "Email Change Link from ShopNScroll";
		subject[1][2] = "Password Change Link from ShopNScroll";
		subject[1][3] = "Payment Pending for Order: " + PARAM_ORDER_TEXT;
		subject[1][4] = "Payment Completed for Order: " + PARAM_ORDER_TEXT;
		subject[1][5] = "Packed - Order: " + PARAM_ORDER_TEXT;
		subject[1][6] = "Dispatched - Order: " + PARAM_ORDER_TEXT;
		subject[1][7] = "Order: " + PARAM_ORDER_TEXT + " has been Cancelled!";
		subject[1][8] = "Out For Delivery - Order: " + PARAM_ORDER_TEXT;
		subject[1][9] = "Order: " + PARAM_ORDER_TEXT + " Delivered!";
		subject[1][10]= "Return for Order: " + PARAM_ORDER_TEXT + " Requested!";
		subject[1][11]= "Order: " + PARAM_ORDER_TEXT + " Returned!";
		subject[1][12]= "Order: " + PARAM_ORDER_TEXT + " Refunded!";
		subject[1][13]= "Promotion for Product: " + PARAM_ORDER_TEXT  + "Activated!!";
		subject[1][14]= "Promotion for Product: " + PARAM_ORDER_TEXT  + "Expiring";
		
		/* BODY['LOCALE_HI' , 'EMAIL_TYPE'] */
		body[1][0] = HTML_HEADER + 
			      "" + 
			      HTML_FOOTER;
		body[1][1] = HTML_HEADER + 
			 	  "" + 
			 	  HTML_FOOTER;
		body[1][2] = HTML_HEADER + 
			 	  "" + 
			      HTML_FOOTER;
		body[1][3] = HTML_HEADER + 
			 	  "" + 
			 	  HTML_FOOTER;
		body[1][4] = HTML_HEADER + 
			 	  "" + 
			 	  HTML_FOOTER;
		body[1][5] = HTML_HEADER + 
			 	  "" + 
			 	  HTML_FOOTER;
		body[1][6] = HTML_HEADER + 
			 	  "" + 
			 	  HTML_FOOTER;
		body[1][7] = HTML_HEADER + 
			 	  "" + 
			 	  HTML_FOOTER;
		body[1][8]= HTML_HEADER + 
			 	  "" + 
			 	  HTML_FOOTER;
		body[1][9] = HTML_HEADER + 
			 	  "" + 
			 	  HTML_FOOTER;
		body[1][10]=HTML_HEADER + 
			 	  "" + 
			 	  HTML_FOOTER;
		body[1][11]= HTML_HEADER + 
				  "" + 
			 	  HTML_FOOTER;
		body[1][12]= HTML_HEADER + 
				  "" + 
			 	  HTML_FOOTER;
		body[1][13]=HTML_HEADER + 
			 	  "" + 
			 	  HTML_FOOTER;
		body[1][14]= HTML_HEADER + 
			 	  "" + 
			 	  HTML_FOOTER;
	}
	
	public String getSubject(Locales loc, EmailType etyp) {
		return subject[loc.ordinal()][etyp.ordinal()];
	}
	
	public String getBody(Locales loc, EmailType etyp) {
		return body[loc.ordinal()][etyp.ordinal()];
	}
}