/*Write a program to store numbers from 1 to 100 in an array. Print out all the even
numbers from the array. Use the enhanced FOR loop for printing out the numbers.*/

package com.homework1.enhancedfor;

public class EnhancedFor {
	public static void main(String[] args) {
		int arr[] = new int[100];

		for(int i= 0; i<100; i++) {
			arr[i] = i+1;
		}

		for(int i : arr)
			if(i==0)
				System.out.println(i);
			else if(i%2 == 0)
				System.out.println(i);
	}
}
