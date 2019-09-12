/*Write a program that would access two float-variables from a class that exists in
another package. Note, you will need to create two packages to demonstrate the
solution.*/

package com.homework1.floatA;

public class FloatA {
	 private float a= 1.1f;
	 private float b = 2.2f;

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

	public float getB() {
		return b;
	}

	public void setB(float b) {
		this.b = b;
	}
}
