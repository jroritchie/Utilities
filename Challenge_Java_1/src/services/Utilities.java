package services;

/**
 * 
 * @author James
 *
 */
public class Utilities {

	private Utilities() {
	}

	public static int nextPrime(int n) {
		
		if (n < 2) {
			return 2;
		}
		
		int m = n;
		
		n += 1;
		
		boolean findPrime = false;
		while (!findPrime) {
			if (n % 2 == 0) {
				n += 1;
				findPrime = false;
			}
			for (int i = 3; i <= ((n / 2) + 2); i += 2) {
				if (n % i == 0) {
					n += 2;
				}
				if (i >= n / 2) {
					findPrime = true;
					System.out.println(n + " is the first prime after " + m);
					break;
				}
			}
		}
		return n;
	}
	
	public static int largestPrime(int n) throws IllegalArgumentException {
		
		if (n <= 0) {
			throw new IllegalArgumentException("cannot call largestPrime(n) with n < 1");
		}
		
		if (n >= 10) {
			throw new IllegalArgumentException("cannot call largestPrime(n) with n => 10 because it's too big!");
		}
		
		int ntest = (int) (java.lang.Math.pow(10, n));
		ntest -= 1;
		
		boolean findPrime = false;
		while (!findPrime) {
			for (int i = 3; i <= ((ntest / 2) + 2); i += 2) {

				//System.out.println(i+"::"+ntest+"::"+(ntest % i)+"::"+(ntest / 2)); // used for debugging purposes
				
				if (checkPrime(ntest) == false) {
					ntest -= 2;
					break;
				}
				if (checkPrime(ntest) == true) {
					findPrime = true;
					System.out.println(ntest + " is the largest prime which contains " + n + " digits.");
					break;
				}
			}
		}
		return ntest;
	}
	
	public static int smallestPrime(int n) throws IllegalArgumentException {
		
		if (n <= 0) {
			throw new IllegalArgumentException("cannot call smallestPrime(n) with n < 1");
		}
		
		int ntest = (int) (java.lang.Math.pow(10, (n-1)));
		ntest += 1;
		
		boolean findPrime = false;
		if (n == 1) {
			System.out.println("2 is the smallest prime which contains " + n + " digits.");
			findPrime = true;
		}
		
		while (!findPrime) {
			for (int i = 3; i <= ((ntest / 2) + 2); i += 2) {

				System.out.println(i+"::"+ntest+"::"+(ntest % i)+"::"+(ntest / 2));
				
				if (checkPrime(ntest) == false) {
					ntest += 2;
					break;
				}
				if (checkPrime(ntest) == true) {
					findPrime = true;
					System.out.println(ntest + " is the smallest prime which contains " + n + " digits.");
					break;
				}
			}
		}
		return ntest;
	}

	public static boolean checkPrime(int n) {
	
		if (n < 2) {
			return false;
		}
	
		boolean checkPrime = false;
		while (!checkPrime) {
			if (n % 2 == 0) {
				return false;
			}
			for (int i = 3; i <= ((n / 2) + 2); i += 2) {
				if (n % i == 0) {
					return false;
				}
				if (i >= n / 2) {
					return true;
				}
			}
		}
		return checkPrime;
	}
	
	//public static String reverseString(String b) {
		
		//reverseB = ;
		
		//return reverseB;
	//}
	
}