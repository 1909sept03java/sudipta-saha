/*Write a program to display the number of characters for a string input. The string
should be entered as a command line argument using (String [ ] args).*/

package com.homework1.commandlineargument;

public class CommandLineArgument {
	public static void main(String[] args) {
		System.out.println("Number of character in argument is: "+args[0].length());
	}
}
