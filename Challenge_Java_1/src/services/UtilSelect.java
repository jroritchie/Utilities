package services;

import java.util.Scanner;

public class UtilSelect {
	public static void main (String[] args) {
		Scanner Select = new Scanner(System.in);
		System.out.println("Choose a utility:");
		System.out.println("Press 1 to find the next prime after a specified number.");
		System.out.println("Press 2 to find the largest prime with n digits.");
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
		Select.close();
	}
}
