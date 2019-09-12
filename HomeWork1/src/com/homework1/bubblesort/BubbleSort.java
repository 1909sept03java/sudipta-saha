package com.homework1.bubblesort;

public class BubbleSort {
	public static void main(String[] args) {
		int arr[] = {1,0,5,6,3,2,3,7,9,8,4};
		arr=bSort(arr);
		for(int i: arr) {
			System.out.print(i+" ");
		}

	}


	//Sorting function
	static int[] bSort(int arr[]) {
		for(int i=0; i<arr.length-1; i++) {
			for(int j = 0; j<arr.length-i-1; j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}

		}
		return arr;
	}

}
