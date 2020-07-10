package org.hov.custom;

import java.util.Random;

public class OTPGenerator 
{
	public String generate(int length)
	{	
		int no = 1;
		String randomNumber = null;	
		Random rand = new Random(); 
		while(length > 0)
		{
			no*=10;
			length--;
		}
        randomNumber = Integer.toString(rand.nextInt(no));	
		return randomNumber;
	}
}
