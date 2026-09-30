package com.al.lab2;
import java.util.Scanner;
import java.math.BigDecimal;

//Armand Lagman

public class MainDriver {
	
	public static void main(String[] args) {
		
		// Creates Scanner to get input from the user
		Scanner input = new Scanner(System.in);

		// Stores 5 Interest objects
		Interest[] interests = new Interest[5];

		// Repeats the input and calculations for 5 objects
		for (int i = 0; i < 5; i++) {

			System.out.println("\n--- Interest Object " + (i + 1) + " ---");

			// Asks the user to enter the principal amount
			System.out.print("Enter principal amount: ");

			if (!input.hasNextBigDecimal()) {
				System.out.println("Error: Principal must be a number.");
				return;
			}

			BigDecimal principal = input.nextBigDecimal();

			// Asks the user to enter the interest rate
			System.out.print("Enter interest rate: ");

			if (!input.hasNextBigDecimal()) {
				System.out.println("Error: Interest rate must be a number.");
				return;
			}

			BigDecimal rate = input.nextBigDecimal();

			// Asks the user to enter the time in years
			System.out.print("Enter time in years: ");

			if (!input.hasNextBigDecimal()) {
				System.out.println("Error: Time must be a number.");
				return;
			}

			BigDecimal time = input.nextBigDecimal();

			try {

				// Creates and stores an Interest object
				interests[i] = new Interest(principal, rate, time);

				// Displays the calculated interest
				System.out.println("Simple Interest: $"
						+ interests[i].calculateSimpleInterest());

				System.out.println("Compound Interest: $"
						+ interests[i].calculateCompoundInterest());

			}
			catch (IllegalArgumentException e) {

				// Displays the error message from the Interest constructor
				System.out.println("Error: " + e.getMessage());
			}
		}

		// Closes the Scanner
		input.close();
	}
}
