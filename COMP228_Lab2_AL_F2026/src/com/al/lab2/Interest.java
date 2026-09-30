package com.al.lab2;

import java.math.BigDecimal;

// Armand Lagman

public class Interest {

	// Stores the principal amount, interest rate, and time
	private BigDecimal principal;
	private BigDecimal rate;
	private int time;

	// Constructor validates the values before storing them
	public Interest(BigDecimal principal, BigDecimal rate, int time) {

		// Validates that the principal is not negative
		if (principal.compareTo(BigDecimal.ZERO) >= 0)

			// Validates that the rate is not negative
			if (rate.compareTo(BigDecimal.ZERO) >= 0)

				// Validates that the time is not negative
				if (time >= 0) {

					// Stores the validated values in the object's attributes
					this.principal = principal;
					this.rate = rate;
					this.time = time;
				}
	}

	// Calculates simple interest using BigDecimal values
	public BigDecimal calculateSimpleInterest() {

		// SI = Principal * Rate * Time / 100
		BigDecimal interest = principal
				.multiply(rate)
				.multiply(BigDecimal.valueOf(time))
				.divide(new BigDecimal("100"));

		return interest;
	}

	// Calculates simple interest using double values - Overloaded method
	public double calculateSimpleInterest(double principal, double rate, double time) {

		double interest = (principal * rate * time) / 100;

		return interest;
	}

	// Calculates compound interest using BigDecimal values
	public BigDecimal calculateCompoundInterest() {

		// Converts the percentage rate to a decimal
		BigDecimal rateDecimal = rate.divide(new BigDecimal("100"));

		// Calculates the total amount after compound interest
		BigDecimal amount = principal.multiply(
				BigDecimal.ONE.add(rateDecimal).pow(time));

		// Subtracts the original principal to get only the interest earned
		BigDecimal interest = amount.subtract(principal);

		return interest;
	}

	// Calculates compound interest using double values - Overloaded Method
	public double calculateCompoundInterest(double principal, double rate, double time) {

		// Converts the percentage rate to a decimal
		double rateDecimal = rate / 100;

		// Calculates the total amount after compound interest
		double amount = principal * Math.pow(1 + rateDecimal, time);

		// Subtracts the original principal to get only the interest earned
		double interest = amount - principal;

		return interest;
	}
}