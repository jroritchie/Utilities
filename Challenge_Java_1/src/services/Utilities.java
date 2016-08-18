package services;

import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

/**
 * 
 * @author James
 *
 */
public class Utilities {

	private Utilities() {
	}

	public static int nextPrime(int n) {
		
		if (n < 2) { // the first prime is 2, so any number less than two will result in two
			return 2;
		}
				
		int m = n;
		boolean findPrime = false;
		n += 1;
		
		if (n == 3) { // checks to see if the inputed number was 2, and returns 3 accordingly.
			findPrime = true;
			System.out.println("3 is the first prime after 2");
			return 3;
		}
		
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
		
		if (n >= 10) { // 32 bit java only allows calculations up to ~ 2 x 10^9
			throw new IllegalArgumentException("cannot call largestPrime(n) with n => 10 because it's too big!");
		}
		
		int ntest = (int) (java.lang.Math.pow(10, n)); // puts 10 to the power of n, then -1 to get to an integer containing only the digit 9
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
		
		if (n >= 11) { // 32 bit java only allows calculations up to ~ 2 x 10^9
			throw new IllegalArgumentException("cannot call largestPrime(n) with n => 11 because it's too big!");
		}
		
		int ntest = (int) (java.lang.Math.pow(10, (n-1)));
		ntest += 1;
		
		boolean findPrime = false;
		if (n == 1) {
			System.out.println("2 is the smallest prime that contains " + n + " digit.");
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
		if (n == 2) { //hard coded as otherwise the loop never starts because n == m from the start.
			System.out.println("3 is the 2nd prime");
			findPrime = true;
		}
		
		while (!findPrime) {
			for (int i = 0; i < 10000000; i++) {
				if (n == m) {
					System.out.println((z-2)  + " is prime number " + m);
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
		return z;
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
//		if (n == 1) {
//			System.out.println("3 and 5 are the 1st prime pair");
//			a1 = 3;
//			findPrime = true;
//		}
//		if (n == 2) {
//			System.out.println("11 and 13 are the 2nd prime pair");
//			a1 = 11;
//			findPrime = true;
//		}
//		if (n == 3) {
//			System.out.println("17 and 19 are the 3rd prime pair");
//			a1 = 17;
//			findPrime = true;
//		}
		
		while (!findPrime) {
			for (int i = 0; i < 10000000; i++) { // pseudo infinite loop because there will always be a next twin prime. 
				if (n == m) {
					System.out.println(a1  + " and " + a2 + " are twin prime number " + m);
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
		
		if (n == 2) { // two is a prime, but it is not checked for in the loop.
			return true;
		}
	
		if (n % 2 == 0) {
				return false;
			}
		for (int i = 3; i*i <= (n + 2); i += 2) {	
			if (i != n && n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int goldbach(int n) throws IllegalArgumentException {
		
		if (n <= 3) {
			throw new IllegalArgumentException("cannot call goldbach(n) with n < 4");
		}
		
		List<Integer> primeList = new ArrayList<Integer>();
		primeList.add(2); // adds two to the list because two is not checked as a prime
		//primeList.add(3)
		

		for (int i = 3; i < n; i+=2) { // get a list of primes up to the goldbach value
			if (checkPrime(i)) {
				primeList.add(i);
			}
		}
		
		// for each prime below goldbach value:
//		 int l = primeList.size() - 1;
		 for (int l: primeList) {
//		 for (primeList.get(l); l>1; l-=1) { 

		//		test all primes from highest to lowest.
				for (int j = primeList.size() - 1; j>=0; j-=1) {
					if (l + primeList.get(j) == n) {
						System.out.println(n + " = " + l + " " + primeList.get(j));
						return l;
						}
				}
		 }
		 System.out.println("What the hell happened?!?!?!?");
		 return 0; // making the compiler happy :/
	}
	
	public static String[] reverseString(String c) {
		
		String[] b = c.split("");

		//System.out.println(b.toString());
		
		int length = c.length();
		
		//System.out.println(length);
		
		String[] rb = new String[length];
		int y = length;
		for (int x = 0; x < length; x++) {
			rb[x] = b[y];
			System.out.print(rb[x]);
			y -= 1;
		}
		
		return rb;
	}
	
	public static int[] sort(int[] array) {
		
		int n = 0;
		int temp;
		
		int length = array.length;

		while (true) {
			for (int y = 0; y<length-1; y++) {
				if (array[y] <= array[y+1]) {
					n += 1;
					if (n == length) {
						for (int l = 0; l<=length-1; l++) {
							System.out.print(array[l]);
							System.out.print(", ");
						}
						return array;
					}
				}
				if ((int)array[y] >= (int)array[y+1]) {
					n = 0;
					temp = array[y];
					array[y] = array[y+1];
					array[y+1] = temp;
				}
			}
		}
	}
}