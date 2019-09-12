/*Write a program that defines an interface having the following methods: addition,
subtraction, multiplication, and division. Create a class that implements this interface
and provides appropriate functionality to carry out the required operations. Hard code
two operands in a test class having a main method that calls the implementing class.*/

package com.homework1.interfaceHW;

public class InterfaceHWimplement implements InterfaceHW  {
	public static void main(String[] args) {
		int a =6, b=2;
		System.out.println("Input 6 and 2");
		InterfaceHWimplement interfaceHWimplement = new InterfaceHWimplement();
		System.out.println("Addition:");
		System.out.println(interfaceHWimplement.addition(a, b));
		System.out.println("Subtraction:");
		System.out.println(interfaceHWimplement.subtraction(a, b));
		System.out.println("Multiplication:");
		System.out.println(interfaceHWimplement.multiplication(a, b));
		System.out.println("Division:");
		System.out.println(interfaceHWimplement.division(a, b));
	}

	@Override
	public int addition(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int subtraction(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public int multiplication(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public double division(int a, int b) {
		// TODO Auto-generated method stub
		return a/b;
	}

}
