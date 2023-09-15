/**
 * 
 */
package com.rcs2.cms.utility;

/**
 * @author janaka
 *
 */
public class Utility {
	
	 public static volatile int tokenNumber = 0;
	 
	 public static synchronized int setTokenNumber(int number){
		 tokenNumber=number;
		 return tokenNumber;
	 }

}
