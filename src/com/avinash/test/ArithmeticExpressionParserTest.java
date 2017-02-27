package com.avinash.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.avinash.calculator.ArithmeticExpressionParser;

public class ArithmeticExpressionParserTest {

	@Test
	public void testCalculateExpression() {
		ArithmeticExpressionParser arithmeticExpressionParser = new ArithmeticExpressionParser();
		double result = arithmeticExpressionParser.calculateExpression("8*5-6/3*4");
		assertEquals(32.0,result,0.0);
	}

}
