/*Write a substring method that accepts a string str and an integer idx and returns the
substring contained between 0 and idx-1 inclusive. Do NOT use any of the existing
substring methods in the String, StringBuilder, or StringBuffer APIs.*/

package com.homework1.substring;

import java.util.Scanner;

public class Substring {
	public static void main(String[] args) {
		String str;
		int idx;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the String: ");
		str = scanner.nextLine();
		System.out.println("Enter the subtring ending point: ");
		idx = scanner.nextInt();
		substring(str, idx);
	}
	//substring method
	static void substring(String str,int idx) {
		String substring="";
		for(int j = 0; j<idx;j++) {
			substring += str.charAt(j);
		}
		System.out.println("Desired substring: "+substring);
	}

}
