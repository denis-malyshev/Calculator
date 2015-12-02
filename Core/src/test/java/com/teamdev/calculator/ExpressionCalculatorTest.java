package com.teamdev.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionCalculatorTest {

    final MathExpressionCalculator calculator=new MathExpressionCalculator();

    @Test
    public void testShortSimpleExpression() throws Exception {
        double result=calculator.calculate("2+3");
        assertEquals("result must be 5",5.0,result,0);
    }

    @Test
    public void testLongSimpleExpression() throws Exception {
        double result=calculator.calculate("2+3+7-9-5+4-10+16");
        assertEquals("result must be 5",8.0,result,0);
    }

    @Test
    public void testExpressionWithManyBrackets() throws Exception {
        double result=calculator.calculate("2*((3+(8-1+(2*(5-6))+7-(3-2))))");
        assertEquals("result must be",28.0,result,0);
    }
}
