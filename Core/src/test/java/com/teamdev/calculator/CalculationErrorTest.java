package com.teamdev.calculator;


import org.junit.Test;

public class CalculationErrorTest {

    final MathExpressionCalculator calculator=new MathExpressionCalculator();

    @Test(expected = CalculationError.class)
    public void testInvalidStartExpression() throws Exception {
        calculator.calculate("+2");
    }

    @Test(expected = CalculationError.class)
    public void testInvalidExpression() throws Exception {
        calculator.calculate("456-sin35");
    }
}
