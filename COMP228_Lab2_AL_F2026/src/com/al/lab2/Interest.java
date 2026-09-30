package com.al.lab2;

import java.math.BigDecimal;

//Armand Lagman

public class Interest {
	
	// Storing the principal amount, interest rate, and time
	private BigDecimal principal; 
	private BigDecimal rate;
	private BigDecimal time;
	
	public Interest(BigDecimal principal, BigDecimal rate, BigDecimal time) {
		
		// Checks that principal, rate and time are not negative
		if (principal.compareTo(BigDecimal.ZERO) < 0 ||
			rate.compareTo(BigDecimal.ZERO) < 0 ||
			time.compareTo(BigDecimal.ZERO) < 0) {
			
			throw new IllegalArgumentException(
					"Principal, rate, and time cannot be negative");
		}
		
		// Checks that principal and rate are decimal values
		if (principal.scale() <= 0 || rate.scale() <= 0) {
			throw new IllegalArgumentException(
					"Principal and rate must be decimal values");
		}
		
		// Assigning the validated values to the objects attributes
		this.principal = principal;
		this.rate = rate;
		this.time = time;
		
	}
	
	// Calculates simple interest using BigDecimal values
		public BigDecimal calculateSimpleInterest() {
			BigDecimal interest = principal
				.multiply(rate)
				.multiply(time)
				.divide(new BigDecimal("100"));
		
			return interest;
				
		}
		
		// Calculates compound interest using BigDecimal values
		public BigDecimal calculateCompoundInterest() {
			
			// Converts the percentage rate to a decimal
			BigDecimal rateDecimal = rate.divide(new BigDecimal("100"));
			
			// Calculates the total amount after compound interest
			BigDecimal amount = principal.multiply(
					BigDecimal.ONE.add(rateDecimal).pow(time.intValue()));
			
			// Subtracts the principal to get only the interest earned
			BigDecimal interest = amount.subtract(principal);
					
			return interest;
		}
		
		// Calculates compound interest using double values
		public double calculateCompoundInterest(double principal, double rate, double time) {

			double rateDecimal = rate / 100;

			double amount = principal * Math.pow(1 + rateDecimal, time);

			double interest = amount - principal;

			return interest;
		}
		
		//Calculates simple interest using double values
		public double calculateSimpleInterest(double principal, double rate, double time) {
			
			double interest = (principal * rate * time) / 100;
			
			return interest;
		}
	
	
}


