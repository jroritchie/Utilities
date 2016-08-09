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
			if (n == 3) {
				findPrime = true;
				System.out.println("3 is the first prime after 2");
				break;
			}
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
			System.out.println("2 is the smallest prime that contains " + n + " digits.");
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
	
	public static int nthPrime(int n) throws IllegalArgumentException {
		
		if (n <= 0) {
			throw new IllegalArgumentException("cannot call nthPrime(n) with n < 1");
		}
		
		int m = 2;
		int z = 3;
		
		boolean findPrime = false;
		if (n == 1) {
			System.out.println("2 is the 1st prime");
			findPrime = true;
		}
		if (n == 2) {
			System.out.println("3 is the 2nd prime");
			findPrime = true;
		}
		if (n == 3) {
			System.out.println("5 is the 3rd prime");
			findPrime = true;
		}
		
		while (!findPrime) {
			for (int i = 0; i < 10000000; i++) {
				if (n == m) {
					System.out.println((z-2)  + " is the " + m + "th prime.");
					findPrime = true;
					break;
				}
				if (checkPrime(z) == false) {
					z += 2;
					break;
				}
				if (checkPrime(z) == true) {
					z += 2;
					m += 1;
					break;
				}
			}
		}
		return n;
	}
	
	public static int twinPrime(int n) throws IllegalArgumentException {
		
		if (n <= 0) {
			throw new IllegalArgumentException("cannot call nthPrime(n) with n < 1");
		}
		
		int m = 0;
		int z = 3;
		int a1 = 0;
		int a2 = 0;
		
		boolean findPrime = false;
		if (n == 1) {
			System.out.println("3 and 5 are the 1st prime pair");
			a1 = 3;
			findPrime = true;
		}
		if (n == 2) {
			System.out.println("11 and 13 are the 2nd prime pair");
			a1 = 11;
			findPrime = true;
		}
		if (n == 3) {
			System.out.println("17 and 19 are the 3rd prime pair");
			a1 = 17;
			findPrime = true;
		}
		
		while (!findPrime) {
			for (int i = 0; i < 10000000; i++) {
				if (n == m) {
					System.out.println(a1  + " and " + a2 + " are the " + m + "th twin prime.");
					findPrime = true;
					break;
				}
				if (checkPrime(z) == false) {
					z += 2;
					break;
				}
				if (checkPrime(z) == true) {
					a1 = z;
					z += 2;
					if (checkPrime(z) == true) {
						a2 = z;
						z += 2;
						m += 1;
						break;
					}
				}
			}
		}
		return a1;
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