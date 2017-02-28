package com.avinash.calculator;

public class Subraction extends BinaryOperation {

	private static Subraction instance = new Subraction('-', Operator.MINUS);

	private Subraction(char symbol, Operator operator) {
		this.symbol = symbol;
		this.operator = operator;

	}

	public static Subraction getInstance() {
		return instance;
	}

	@Override
	public double resultFor(double left, double right) {
		return right - left;
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
