package services.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import services.PasswordCrack;
import services.Utilities;

public class UtilitiesTest {

	@Test
	public void checkPrime1() {
		assertTrue(Utilities.checkPrime(3));
	}
	
	@Test
	public void checkPrime2() {
		assertFalse(Utilities.checkPrime(16));
	}
	
	@Test
	public void checkPrime3() {
		assertTrue(Utilities.checkPrime(2));
	}
	
	@Test
	public void checkPrime4() {
		assertFalse(Utilities.checkPrime(0));
	}
	
	@Test
	public void testNextPrime1() {
		assertTrue(Utilities.nextPrime(6) == 7);
	}

	@Test
	public void testNextPrime2() {
		assertTrue(Utilities.nextPrime(48) == 53);
	}
	
	@Test
	public void testNextPrime3() {
		assertTrue(Utilities.nextPrime(1) == 2);
	}

	@Test
	public void testLargestPrime1() {
		assertTrue(Utilities.largestPrime(1) == 7);
	}
	
	@Test
	public void testLargestPrime2() {
		assertTrue(Utilities.largestPrime(2) == 97);
	}

	@Test
	public void testLargestPrime3() {
		assertTrue(Utilities.largestPrime(3) == 997);
	}
	
	@Test
	public void testLargestPrime4() {
		assertTrue(Utilities.largestPrime(4) == 9973);
	}
	
	@Test
	public void testLargestPrime5() {
		assertTrue(Utilities.largestPrime(5) == 99991);
	}
	
	@Test
	public void testLargestPrime6() {
		assertTrue(Utilities.largestPrime(6) == 999983);
	}
	
	@Test
	public void testLargestPrime7() {
		assertTrue(Utilities.largestPrime(7) == 9999991);
	}
	
	@Test
	public void testLargestPrime8() {
		assertTrue(Utilities.largestPrime(8) == 99999989);
	}
	
//	@Test //Warning! Will take a while!
//	public void testLargestPrime9() {
//		assertTrue(Utilities.largestPrime(9) == 999999937);
//	}
	
	@Test
	public void testLargestPrime10() {
		try {
			Utilities.largestPrime(10);
			fail("this should throw an Exception");
		}
		catch (Exception e) {
			// pass
		}
	}
	
	@Test
	public void testLargestPrime11() {
		try {
			Utilities.largestPrime(0);
			fail("this should throw an Exception");
		}
		catch (Exception e) {
			// pass
		}
	}
	@Test
	public void testSmallestPrime1() {
		assertTrue(Utilities.smallestPrime(1) == 2);
	}
	
	@Test
	public void testSmallestPrime2() {
		assertTrue(Utilities.smallestPrime(2) == 11);
	}

	@Test
	public void testSmallestPrime3() {
		assertTrue(Utilities.smallestPrime(3) == 101);
	}
	
	@Test
	public void testSmallestPrime4() {
		assertTrue(Utilities.smallestPrime(4) == 1009);
	}
	
	@Test
	public void testSmallestPrime5() {
		assertTrue(Utilities.smallestPrime(5) == 10007);
	}
	
	@Test
	public void twinPrime1() {
		assertTrue(Utilities.twinPrime(1) == 3);
	}
	
	@Test
	public void twinPrime2() {
		assertTrue(Utilities.twinPrime(2) == 11);
	}
	
	@Test
	public void twinPrime3() {
		assertTrue(Utilities.twinPrime(3) == 17);
	}
	
	@Test
	public void twinPrime4() {
		assertTrue(Utilities.twinPrime(4) == 29);
	}
	
	@Test
	public void twinPrime5() {
		assertTrue(Utilities.twinPrime(5) == 41);
	}
	
	@Test
	public void goldbach1() {
		assertTrue(Utilities.goldbach(6) == 3);
	}
	
	@Test
	public void goldbach2() {
		assertTrue(Utilities.goldbach(12) == 5);
	}
	
	@Test
	public void crackPassword() {
		assertTrue(PasswordCrack.crackPassword("827ccb0eea8a706c4c34a16891f84e7b") == "12345");
	}
}
