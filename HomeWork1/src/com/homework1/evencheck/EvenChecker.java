/*Write a program to determine if an integer is even without using the modulus
operator (%)*/

package com.homework1.evencheck;

import java.util.Scanner;

public class EvenChecker {
	public static void main(String[] args) {
		int i;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number to check even: ");
		i = scanner.nextInt();
		if(evenCheck(i))
			System.out.println(i+" is even");
		else System.out.println(i+" is odd");
	}

	static boolean evenCheck(int i) {
		int n=i;
		for(; ; ) {
			if((n-2 == 0) || (n-2 == -2) ) {
				return true;
			}else if(n-2 == -1) {
				return false;
			}
			n -= 2; 
		}
	}

}
