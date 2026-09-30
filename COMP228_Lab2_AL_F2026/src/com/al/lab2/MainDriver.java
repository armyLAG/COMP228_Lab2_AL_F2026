package com.al.lab2;

import java.util.Scanner;
import java.math.BigDecimal;

// Armand Lagman

public class MainDriver {

	public static void main(String[] args) {

		// Creates Scanner to read input from the user
		Scanner scanner = new Scanner(System.in);

		// Creates an array that can store 5 Interest objects
		Interest[] investments = new Interest[5];

		// Repeats the input process for all 5 investments
		for (int i = 0; i < investments.length; i++) {

			System.out.println("\nInvestment " + (i + 1));

			// Gets the principal amount from the user
			System.out.print("Enter Principal: ");
			BigDecimal principal = scanner.nextBigDecimal();

			// Gets the interest rate from the user
			System.out.print("Enter Interest Rate (%): ");
			BigDecimal rate = scanner.nextBigDecimal();

			// Gets the time in years from the user
			System.out.print("Enter Time (years): ");
			int time = scanner.nextInt();

			try {

				// Creates an Interest object and stores it in the array
				investments[i] = new Interest(principal, rate, time);

				// Displays the simple interest
				System.out.println("Simple Interest: $"
						+ investments[i].calculateSimpleInterest());

				// Displays the compound interest
				System.out.println("Compound Interest: $"
						+ investments[i].calculateCompoundInterest());

			}
			catch (ArrayIndexOutOfBoundsException e) {

				// Displays information about an array index error
				e.printStackTrace();
				e.getCause();
				e.getMessage();
			}
			catch (ArithmeticException e) {

				// Displays information about a calculation error
				e.printStackTrace();
				e.getCause();
				e.getMessage();
			}
			catch (IndexOutOfBoundsException e) {

				// Displays information about an index error
				e.printStackTrace();
				e.getCause();
				e.getMessage();
			}
		}

		// Closes the Scanner after all inputs are finished
		scanner.close();
	}
}