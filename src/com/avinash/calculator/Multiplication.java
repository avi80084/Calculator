package com.avinash.calculator;

public class Multiplication extends BinaryOperation {

	private static Multiplication instance = new Multiplication('*', Operator.MULTIPLY);

	private Multiplication(char symbol, Operator operator) {
		this.symbol = symbol;
		this.operator = operator;
	}

	public static Multiplication getInstance() {
		return instance;
	}

	@Override
	public double resultFor(double left, double right) {
		return left * right;
	}

	@Override
	public int compareTo(BinaryOperation o) {

		if (this.operator.priority < o.operator.priority) {
			return -1;
		} else if (this.operator.priority > o.operator.priority) {
			return 1;
		}
		return 0;
	}
}