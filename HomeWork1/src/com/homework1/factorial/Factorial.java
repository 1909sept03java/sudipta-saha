package com.homework1.factorial;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number to do factorial: ");
		n = scanner.nextInt();

		System.out.println(n+ "! is: "+factorial(n));

	}

	static int factorial(int n) {
		if(n == 0) {
			return 1;
		}else {
			return n*factorial(n-1);
		}
	}

}
