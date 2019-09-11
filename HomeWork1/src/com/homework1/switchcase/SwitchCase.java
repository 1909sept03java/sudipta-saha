package com.homework1.switchcase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SwitchCase {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		int i;
		System.out.println("Enter choice 1 to 3: ");
		i= scanner.nextInt();
		
		switch(i) {
		case 1: squareRoot();
				break;
		case 2: todaysDate();
				break;
		case 3: stringSplit("I am learning Core Java");
				break;
		}

	}
	
	static void squareRoot() {
		int i;
		System.out.println("Enter the number to do square root: ");
		i= scanner.nextInt();
		System.out.println("Root of "+i+" is: "+ Math.sqrt(i));
		
	}
	
	static void todaysDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
	}
	static void stringSplit(String str) {
		String[] split = str.split(" ");
		for (String string : split) {
			System.out.println(string);
		}
	}
	
}
