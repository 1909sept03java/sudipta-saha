package com.homework1.evencheck;

import java.util.Scanner;

public class EvenChecker {
	public static void main(String[] args) {
		int n,i;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number to check even: ");
		i = scanner.nextInt();
		n=i;
		
		for(; ; ) {
			if((n-2 == 0) || (n-2 == -2) ) {
				System.out.println(i+" is even");
				break;
			}else if(n-2 == -1) {
				System.out.println(i+" is odd");
				break;
			}
			n -= 2; 
		}
	}

}
