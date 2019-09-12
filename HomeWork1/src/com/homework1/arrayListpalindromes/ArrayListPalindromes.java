/*Write a program that stores the following strings in an ArrayList and saves all the
palindromes in another ArrayList.
“karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”, “refer”, “billy”,
“did”*/

package com.homework1.arrayListpalindromes;

import java.util.ArrayList;

public class ArrayListPalindromes {
	public static void main(String[] args) { 
		ArrayList<String> arraylist = new ArrayList<String>();
		arraylist.add("karan");
		arraylist.add("madam");
		arraylist.add("tom");
		arraylist.add("civic");
		arraylist.add("radar");
		arraylist.add("sexes");
		arraylist.add("jimmy");
		arraylist.add("kayak");
		arraylist.add("john");
		arraylist.add("refer");
		arraylist.add("billy");
		arraylist.add("did");
		System.out.println("Input list: ");
		for(String s : arraylist) {
			System.out.println(s);
		}
		System.out.println("Palindromes in the list: ");
		arraylist = palindrome(arraylist);
		for(String s : arraylist) {
			System.out.println(s);
		}


	}
	static ArrayList<String> palindrome(ArrayList<String> arraylist) {
		ArrayList<String> palindromes = new ArrayList<String>();
		//Checking if the string is a palindrome 
		for(int i=0; i<arraylist.size(); i++) {
			String str = arraylist.get(i);
			int length = str.length()-1;
			int flag = 1;
			for(int j= 0; j<=length/2 ; j++) {
				if(str.charAt(j) != str.charAt(length)) {
					flag = 0;
					break;
				}
				length--;
			}
			if(flag == 1) {
				palindromes.add(str);
			}
		}
		return palindromes;

	}
}
