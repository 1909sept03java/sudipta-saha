/*Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime
numbers to the console.*/

package com.homework1.arraylistprime;

import java.util.ArrayList;

public class ArraylistPrime {
	public static void main(String[] args) {
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		for(int i = 1; i<=100; i++) {
			arraylist.add(i);
		}
		arraylist = primeChecker(arraylist);
		
		for (int  i : arraylist) {
			System.out.println(i);
		}

	}

	////Checking if the number is a prime 
	static ArrayList<Integer> primeChecker(ArrayList<Integer> arraylist) {
		ArrayList<Integer> prime = new ArrayList<Integer>();
		for(int i : arraylist) {
			int flag =1;//flag to check prime. if 1 then prime
			if(i!=1) {
				for(int j = 2; j <= (i/2); j++) {
					if(i%j == 0) {
						flag = 0;
						break;
					}
				}
				if(flag == 1)
					prime.add(i);
			}
		}
		return prime;
	}

}
