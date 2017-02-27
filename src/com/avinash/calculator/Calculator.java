package com.avinash.calculator;

import java.util.Scanner;

public class Calculator {

	// main class
		public static void main(String[] args) {
			ArithmeticExpressionParser expression = new ArithmeticExpressionParser();
			Scanner s = new Scanner(System.in);
			System.out.println("Enter the expression to parse");
			String ex = s.nextLine();
			try
			{
			double result = expression.calculateExpression(ex);
			System.out.println("The result is : " +result);
			}catch (Exception e)
			 {
			    System.out.println("Exception is : " + e.toString( ));
			 }
			
			s.close();
		}
}
