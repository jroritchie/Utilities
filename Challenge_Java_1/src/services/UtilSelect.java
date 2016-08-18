package services;

import java.util.Scanner;

public class UtilSelect {
	public static void main (String[] args) {
		Scanner Select = new Scanner(System.in);
		System.out.println("Choose a utility:");
		System.out.println("Press 1 to find the next prime after a specified number.");
		System.out.println("Press 2 to find the largest prime with n digits.");
		System.out.println("Press 3 to find the smallest prime with n digits.");
		System.out.println("Press 4 to find the nth prime.");
		System.out.println("Press 5 to find the nth twin primes.");
		System.out.println("Press 6 to find goldbach n.");
		System.out.println("Press 7 to find a password of n characters.");
		System.out.println("Press 8 to encode a string.");
		System.out.println("Press 9 to reverse string 'n'.");
		int z = Select.nextInt();
		if (z == 1) {
			Scanner userInput = new Scanner(System.in);
			System.out.println("Enter a number: ");
			int n = userInput.nextInt();
			Utilities.nextPrime(n);
			userInput.close();
		}
		
		if (z == 2) {
			Scanner userInput = new Scanner(System.in);
			System.out.println("Enter a number: ");
			int n = userInput.nextInt();
			Utilities.largestPrime(n);
			userInput.close();
		}
		
		if (z == 3) {
			Scanner userInput = new Scanner(System.in);
			System.out.println("Enter a number: ");
			int n = userInput.nextInt();
			Utilities.smallestPrime(n);
			userInput.close();
		}
		
		if (z == 4) {
			Scanner userInput = new Scanner(System.in);
			System.out.println("Enter a number: ");
			int n = userInput.nextInt();
			Utilities.nthPrime(n);
			userInput.close();
		}
		
		if (z == 5) {
			Scanner userInput = new Scanner(System.in);
			System.out.println("Enter a number: ");
			int n = userInput.nextInt();
			Utilities.twinPrime(n);
			userInput.close();
		}
		
		if (z == 6) {
			Scanner userInput = new Scanner(System.in);
			System.out.println("Enter a number: ");
			int n = userInput.nextInt();
			Utilities.goldbach(n);
			userInput.close();
		}
		
//		if (z == 7) {
//			Scanner userInput = new Scanner(System.in); // not implemented yet
//			System.out.println("Enter an encoded password: ");
//			String n = userInput.next();
//			PasswordCrack.crackPassword(n);
//			userInput.close();
//		}
		
		if (z == 8) {
			Scanner userInput = new Scanner(System.in);
			System.out.println("Enter a string: ");
			String n = userInput.next();
			EncodePassword.encodePassword(n);
			userInput.close();
		}
		
		if (z == 9) {
			Scanner userInput = new Scanner(System.in);
			System.out.println("Enter a string: ");
			String n = userInput.next();
			Utilities.reverseString(n);
			userInput.close();
		}
		
		if (z == 10) {
		
			Scanner input = new Scanner(System.in);
			System.out.println("Enter the number of items in the array: ");
			int j = input.nextInt();
			int[] array = new int[j];

			for (int i = 0; i < array.length; i++)
		    {
		        System.out.println("Please enter the next number");
		        array[i] = input.nextInt();
		    }
		input.close(); // making the compiler happy
		Utilities.sort(array);
		}
		Select.close();
	}
}
