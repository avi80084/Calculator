package com.avinash.calculator;


public class Division implements BinaryOperation {
    
	@Override
	public double resultFor(double left, double right) {
		// TODO Auto-generated method stub
		if(left != 0){
		return right / left;
		}
		else {
			throw new NumberFormatException("Division by zero is not possible");
		}
	}
}
