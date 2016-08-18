package services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncodePassword {
	/** Message Digest to use*/
	static MessageDigest md = null; 
	
	/** 
	 * Static initializer to get an instance of a MD5 hash
	 */
	static {
		try {
			md = MessageDigest.getInstance("MD5");			
		}
		catch (NoSuchAlgorithmException nsa) {
			System.out.println("**ERROR**: could not get MD5 algorithm, startup failed");
		}
	}
	public static void main(String[] args) {
		encodePassword(null);
	}
	public static String encodePassword(String n) {
		String test = n;
		String result = hashString(test);
		System.out.println(result);
		return result;
	}
	/**
	 * Takes a String and returns the hash 
	 * 
	 * @param s the String to convert
	 * @return the resulting hash
	 */
	public static String hashString(String s) {
		// convert the string as a byte[] array
		byte[] b = s.getBytes();
		// get the MD5 hash
		byte[] b2 = md.digest(b);
		// and encode the bytes as a String again
		return encodeString(b2);
	}
	/**
	 * Utility method that takes a byte array and returns a hex-encoded String
	 * 
	 * @param b a byte array to encode
	 * @return the resulting string 
	 */
	private static String encodeString(byte[] b) {
		// build using a StringBuffer
		StringBuffer sb = new StringBuffer();
		// do the clever bit 
		for (int i=0;i<b.length;i++) {
			sb.append(Integer.toHexString((b[i] & 0xFF) | 0x100).substring(1,3));
		}
		// return the result as a String
		return sb.toString();
	}	
}