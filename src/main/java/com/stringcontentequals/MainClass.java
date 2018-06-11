/**
 * 
 */
package com.stringcontentequals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Shrikant
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pattern p = Pattern.compile("DPO");
		 Matcher m = p.matcher("BWDPO,ABC");
		 if(m.find()) {
			System.out.println("true"); 
		 }else {
			 System.out.println("false");
		 }
		 }
	

}
