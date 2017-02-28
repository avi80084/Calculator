package com.avinash.calculator;

/**
 * 
 * @author avinash
 *This is an abstract class which has an abstract method for calculating the two operands values 
 *and this method is inherited by different classes and also it implements comparable interface 
 *to compare two operator priorities
 */
public abstract class BinaryOperation implements Comparable<BinaryOperation> {
	   
	char symbol;
	Operator operator;
	public abstract double resultFor(double left, double right);
}

 
