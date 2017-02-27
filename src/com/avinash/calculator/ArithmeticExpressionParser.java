package com.avinash.calculator;
import java.util.Stack;

public class ArithmeticExpressionParser {

	public double calculateExpression(String expression) {

		Stack<Double> numbers = new Stack<Double>();

		// Created a Stack for accessing operators
		Stack<Character> operators = new Stack<Character>();

		for (int i = 0; i < expression.length(); i++)  {

			// Check for whitespace
			if (expression.charAt(i) != ' ') {

				// if item is a number, push it to numbers stack
				if ((expression.charAt(i) >= '0' && expression.charAt(i) <= '9') || expression.charAt(i) == '.') {
					StringBuffer number = new StringBuffer();
					// if number is more than one digit
					while (i < expression.length() && ((expression.charAt(i) >= '0' && expression.charAt(i) <= '9')
							|| expression.charAt(i) == '.')) {
						number.append(expression.charAt(i++));
					}
					i--;
					numbers.push(Double.parseDouble(number.toString()));

				}

				// if item is an operator.
				else if (BinaryOperationFactory.myOperators.getOrDefault(expression.charAt(i), false))  {
					// Check for top element of operators stack has same or
					// greater precedence
					// to current operator and calculate for the top operator in
					// operators stack
					// with top two elements in numbers stack
					
					while (!operators.empty()&& BinaryOperationFactory.checkPrecedence(expression.charAt(i), operators.peek())) {
						
						numbers.push(BinaryOperationFactory.getOperation(operators.pop()).resultFor(numbers.pop(),numbers.pop()));	
						
					} 
					
					// Push current item to operators stack.
					operators.push(expression.charAt(i));
					
				}
				else {
					throw new IllegalArgumentException("The given expression is not valid");
				}
				//System.out.println("operators::" + operators.toString());
				//System.out.println("numbers::" + numbers.toString());
			}
		}

		// to calculate numbers for remaining elements in operators and numbers
		// stack
		while (!operators.empty()) {
			numbers.push(BinaryOperationFactory.getOperation(operators.pop()).resultFor(numbers.pop(), numbers.pop()));
		}

		// return the final value calculated from numbers stack
			return numbers.pop();

		
	}

}