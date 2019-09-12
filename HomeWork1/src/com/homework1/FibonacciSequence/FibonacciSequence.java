/*Write a program to display the first 25 Fibonacci numbers beginning at 0.
*/
package com.homework1.FibonacciSequence;

public class FibonacciSequence {
	public static void main(String[] args) {
		int i = 0;
		int j = 1;
		System.out.println("The first 25 Fibonacci numbers:");
		System.out.print(i+",");
		System.out.print(j);
		for(int k=0; k < 23; k++) {
			int temp;
			temp = i+j;
			System.out.print(","+temp);
			i = j;
			j = temp;
			
		}
	}
	
}
