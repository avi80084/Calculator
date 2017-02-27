package com.avinash.calculator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BinaryOperationFactory {

	public static BinaryOperation getOperation(Character operation) {
		if (operation == null) {
			return null;
		}
		if (operation == '+') {
			return new Addition();

		} else if (operation == '-') {
			return new Subraction();

		} else if (operation == '*') {
			return new Multiplication();

		} else if (operation == '/') {
			return new Division();
		}

		return null;
	}

	public static final Map<Character, Boolean> myOperators;

	static {
		Map<Character, Boolean> operators = new HashMap<Character, Boolean>();

		operators.put('+', true);
		operators.put('-', true);
		operators.put('*', true);
		operators.put('/', true);
		myOperators = Collections.unmodifiableMap(operators);

	}

	public static int getOperatorValue(int operator) {

		switch (operator) {
		case '-':
			return 1;
		case '+':
			return 1;
		case '*':
			return 2;
		case '/':
			return 2;
		default:
			return 0;

		}

	}

	// Returns true if 'op2' has higher or same priority as 'op1',
	// otherwise returns false.

	public static boolean checkPrecedence(char currentOperator, char stackOperator) {

		if (getOperatorValue(currentOperator) <= getOperatorValue(stackOperator)) {
			return true;
		} else
			return false;
	}
}