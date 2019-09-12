/*Find the minimum of two numbers using ternary operators.
*/
package com.homework1.ternaryoperators;

public class TernaryOperators {
	public static void main(String[] args) {
		int i =2, j = 3, k;
		
		k= i > j ? j : i; //if i is greater than j then return j else return i
		
		System.out.println("Minimum between " + i+" and "+ j+ " is "+ k);
	}

}
