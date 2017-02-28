package com.avinash.calculator;

/**
 * 
 * @author avinash
 *stores the operator priority value
 */

public enum Operator {

	
	PLUS(1),MINUS(1),MULTIPLY(2),DIVIDE(2);
	int priority;
	 Operator(int priority){
		this.priority = priority;
	}
	public int getPriority(){
		return priority;		
	}
			
}
