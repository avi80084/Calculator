package com.avinash.calculator;

import java.util.Scanner;

/**
 * 
 * @author Avinash
 *	This class validates the input expression and passes it to ArithmeticExpressionParser class
 */
public class Calculator {

	
	public static void main(String[] args) {
		ArithmeticExpressionParser expression = new ArithmeticExpressionParser();
		System.out.println("Enter the expression to parse:\n");
		Scanner s = new Scanner(System.in);
		String ex = s.nextLine();
		if (!ex.matches("^\\d+([\\*\\+\\-\\/\\.]\\d+)*")) {
			System.out.println("The input is not valid");
		} else
			try {
				double result = expression.calculateExpression(ex);
				System.out.println("The result is : " + result);
			} catch (Exception e) {
				System.out.println("Exception is : " + e.toString());
			}

		s.close();
	}
}
