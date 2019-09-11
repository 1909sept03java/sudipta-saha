package com.homework1.arraylistprime;

import java.util.ArrayList;

public class ArraylistPrime {
	public static void main(String[] args) {
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		for(int i = 1; i<=100; i++) {
			arraylist.add(i);
		}
		primeChecker(arraylist);

	}

	////Checking if the number is a prime 
	static void primeChecker(ArrayList<Integer> arraylist) {
		for(int i : arraylist) {
			int flag =1;
			if(i!=1) {
				for(int j = 2; j <= (i/2); j++) {
					if(i%j == 0) {
						flag = 0;
						break;
					}
				}
				if(flag == 1)
					System.out.println(i);
			}
		}
	}

}
