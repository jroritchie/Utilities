package services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordCrack {

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
		crackPassword("");
	}
	
	public static String crackPassword(String m) {
		// example for "ABC"
		String p = m;
		String testPassword = p;
		char[] characters = new char[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
		int range = characters.length;
		System.out.println(range);
		int b = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		int n = 5; // number of characters in the password
		char[] pwchar = new char[n];
		for (int pwcharset = 0; pwcharset < n; pwcharset++) {
			pwchar[pwcharset] = 48;
		}
		System.out.println(characters);
		System.out.println(pwchar);
		// get the result
		
		for (int i = 0; i <= range; i++) {
//			if (i%range == 0) {
//				//System.out.println("Success");
//				if (i!=0 && i % range == 0) {
//					j = i;
//					while (j > range) {
//						j -= range-1;
//						//System.out.println(j);
//						//System.out.println(i);
//					}
//					if (j == 62) {
//						j = 0;
//					}
//					pwchar[1] = characters[j];
//				}
//				if (i!=0 && i % Math.pow(range, 2) == 0) {
//					j = i;
//					while (j > range) {
//						j -= (Math.pow(range, 2)-1);
//						//System.out.println(j);
//						//System.out.println(i);
//					}
//					
//					while (j < 0) {
//						j += range;
//					}
//
//					if (j == 62) {
//						j = 0;
//						//System.out.println(j);
//					}
//					pwchar[2] = characters[j];
//				}
//				if (i!=0 && i % Math.pow(range, 3) == 0) {
//					j = i;
//					while (j > range) {
//						j -= (Math.pow(range, 3)-1);
//						//System.out.println(j);
//						//System.out.println(i);
//					}
//					
//					while (j < 0) {
//						j += 62;
//					}
//
//					if (j == 62) {
//						j = 0;
//						//System.out.println(j);
//					}
//					pwchar[3] = characters[j];
//				}
//				if (i!=0 && i % Math.pow(range, 4) == 0) {
//					j = i;
//					while (j > range) {
//						j -= (Math.pow(range, 4)-1);
//						//System.out.println(j);
//						//System.out.println(i);
//					}
//					
//					while (j < 0) {
//						j += 62;
//					}
//
//					if (j == 62) {
//						j = 0;
//						//System.out.println(j);
//					}
//					pwchar[4] = characters[j];
//				}
//			}
			pwchar[0] = characters[(i % range)];
			//System.out.println(pwchar);
			if (i == range) {
				i -= range;
				b += 1;
				if (b == range) {
					b -= range;
					c += 1;
					if (c == range) {
						c -= range;
						d += 1;
						if (d == range) {
							d -= range;
							e += 1;
							System.out.println("e is: "+e);
							if (e == range) {
								System.out.println("You have reached zzzzz");
							}
						}
					}
				}
			}
			pwchar[1] = characters[b];
			pwchar[2] = characters[c];
			pwchar[3] = characters[d];
			pwchar[4] = characters[e];
			String test = new String(pwchar);
			String result = hashString(test);
			//System.out.println(test+" i="+i+" a="+a+" result="+result);
			
			//System.out.println("The hash of "+test+" is "+result);	
			
			if (result.equals(testPassword)) {
				System.out.println("The password is "+test);
				return test;
			}
		}
		String fail = "It did not match.";
		return fail;
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

//mousie,    	69691c7bdcc3ce6d5d8a1361f22d04ac = M
//
//matthew,   	9678f7a7939f457fa0d9353761e189c7 = m3
//
//catherine,	7de13dd362a23575e036d9de55f86e1d = l0l
//
//laura,		81f49847690e243df9aebe73137e5fef = w0Ot
//
//ben,		    29b8b82b83731f4e92cd1353335c54e3