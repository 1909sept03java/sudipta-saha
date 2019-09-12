/*Write a program that calculates the simple interest on the principal, rate of interest
and number of years provided by the user. Enter principal, rate and time through the
console using the Scanner class.

Interest = Principal* Rate* Time*/

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
		interest = interestCal(principle, time, rate);
		System.out.println("Total interest: "+interest);
		
	}
	
	static double interestCal(double principle,double time,double rate) {
		return principle*time*rate;
	}
	
}
