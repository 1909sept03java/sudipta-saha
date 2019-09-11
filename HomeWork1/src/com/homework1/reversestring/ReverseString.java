package com.homework1.reversestring;

import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {
		String str;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the string to reverse: ");
		str = scanner.nextLine();
		int length = str.length();
		for(int i = length-1; i>=0; i--)
			str = str+str.charAt(i);
		str = str.substring(length);
		System.out.println("Reversed String: "+str);
		
		
	}
}
