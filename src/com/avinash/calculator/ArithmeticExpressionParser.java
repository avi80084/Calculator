package com.avinash.calculator;

import java.util.Stack;

/**
 * 
 * @author avinash
 * This class calculates the value of the expression 
 */
public class ArithmeticExpressionParser {

	/**
	 * 
	 * @param expression
	 *            
	 * @return result
	 * it takes input expression as argument and returns the result
	 */
	public double calculateExpression(String expression) {

		Stack<Double> numbers = new Stack<Double>();
		Stack<Character> operators = new Stack<Character>();

		for (int i = 0; i < expression.length(); i++) {

			if (isNumber(expression.charAt(i))) {

				StringBuffer number = new StringBuffer();
				while (i < expression.length() && isNumber(expression.charAt(i))) {
					number.append(expression.charAt(i++));
				}
				i--;
				numbers.push(Double.parseDouble(number.toString()));
			}
			/*
			 * Check for top element of operators stack has same or greater
			 * precedence to current operator and calculate for the top operator
			 * in operators stack with top two elements in numbers stack
			 */
			else {

				while (!operators.empty() && comparePrecedence(expression.charAt(i), operators.peek())) {
					numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop()));
				}
				// Push current item to operators stack.
				operators.push(expression.charAt(i));
			}
		}
		// to calculate numbers for remaining elements in operators and numbers
		// stack
		while (!operators.empty()) {
			numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop()));
		}
		// return the final value calculated from numbers stack
		return numbers.pop();
	}

	/**
	 * 
	 * @param newOperator
	 * @param stackOperator
	 * @return compares the precedence values 
	 */
	public boolean comparePrecedence(char newOperator, char stackOperator) {
		return BinaryOperationFactory.getOperation(newOperator)
				.compareTo(BinaryOperationFactory.getOperation(stackOperator)) <= 0;
	}

	/**
	 * 
	 * @param ch
	 * @param a
	 * @param b
	 * @return 
	 * calculates each operation 
	 */
	public double applyOperation(char ch, double a, double b) {

		return BinaryOperationFactory.getOperation(ch).resultFor(a, b);
	}

	/**
	 * 
	 * @param c
	 * @return 
	 * checks if the character is a number
	 */
	public boolean isNumber(char c) {
		return (c >= '0' && c <= '9') || c == '.';
	}

}