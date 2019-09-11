package com.homework1.interestCalculator;

import java.util.Scanner;

public class InterestCalculator {
	public static void main(String[] args) {
		double interest,principle,time,rate;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the principle: ");
		principle= scanner.nextDouble();
		System.out.println("Enter the time: ");
		time = scanner.nextDouble();
		System.out.println("Enter the interest rate: ");
		rate = scanner.nextDouble();
		interest = principle*time*rate;
		System.out.println("Total interest: "+interest);
		
	}
	
}
