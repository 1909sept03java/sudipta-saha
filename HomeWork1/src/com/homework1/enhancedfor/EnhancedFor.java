package com.homework1.enhancedfor;

public class EnhancedFor {
	public static void main(String[] args) {
		int arr[] = new int[100];
		
		for(int i= 0; i<100; i++) {
			arr[i] = i+1;
		}
		
		for(int i : arr)
			System.out.println(i);
	}
}
