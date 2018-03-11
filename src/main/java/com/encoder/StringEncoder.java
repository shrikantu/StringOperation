/**
 * 
 */
package com.encoder;

public class StringEncoder {

	private final static char LOWER_CASE_A = 'a';
	private final static char LOWER_CASE_Z = 'z';
	
	private final static char UPPER_CASE_A = 'A';
	private final static char UPPER_CASE_Z = 'Z';

	public static void main(String[] args) {
		// Plaintext
		String original = "Z@!#a";

		int offset = 1;
		System.out.println(encode(offset, original));

	}

	public static String encode(int offset, String original) {
		StringBuilder encodedText = new StringBuilder();
		if (offset != 1 && offset != -1) {
			throw new RuntimeException("Invalid offset value passed , Acceptable values are 1 or -1");
		}
		if (original == null || original.isEmpty()) {
			throw new RuntimeException("Invalid input to encode");
		}
		for (int i = 0; i < original.length(); i++) {
			encodedText.append(rotate(original.charAt(i), offset));
		}
		return encodedText.toString();

	}

	private static char rotate(char c, int offset) {
		// Keep shift within range of alphabet
		offset %= 26;

		// Only rotate alphabet and only letters
		if ((c >= LOWER_CASE_A) && (c <= LOWER_CASE_Z)) {
			c += offset;
			if (c > LOWER_CASE_Z) {
				// correct overflow lower case alphabet
				c = (char) ((c - LOWER_CASE_Z + LOWER_CASE_A) - 1);                //z+1-z+a-1=a   //offset=1 and String z
			} else if (c < LOWER_CASE_A) {
				// correct underflow lower case alphabet
				c = (char) ((LOWER_CASE_Z + c) - LOWER_CASE_A + 1);                //z+a-a+1=z   //offset=-1 and string a
			}
		} else if ((c >= UPPER_CASE_A) && (c <= UPPER_CASE_Z)) {
			c += offset;
			if (c > UPPER_CASE_Z) {
				// correct overflow for upper case alphabet
				c = (char) ((c - UPPER_CASE_Z + UPPER_CASE_A) - 1);                //Z+1-Z+A-1=A   //offset=1 and String Z
			} else if (c < UPPER_CASE_A) {
				// correct underflow upper case alphabet
				c = (char) ((UPPER_CASE_Z + c) - UPPER_CASE_A + 1);                //Z+A-A+1=Z   //offset=-1 and string A
			}
		}
		return c;
	}
}
