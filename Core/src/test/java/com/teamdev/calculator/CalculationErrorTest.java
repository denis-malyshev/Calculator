package com.teamdev.calculator;


import org.junit.Test;

public class CalculationErrorTest {

    final MathExpressionCalculator calculator=new MathExpressionCalculator();

    @Test(expected = CalculationError.class)
    public void testInvalidStartExpression() throws Exception {
        calculator.calculate(" + 2 ");
    }

    @Test(expected = CalculationError.class)
    public void testInvalidExpression() throws Exception {
        calculator.calculate(" 456 - sin (35) ");
    }

    @Test(expected = CalculationError.class)
    public void testDivisionByZero() throws Exception {
        calculator.calculate(" 2 / (3 + 6 - 9)");
    }

    @Test(expected = CalculationError.class)
    public void testFunctionWithMinArguments() throws Exception {
        calculator.calculate("sum (2)");
    }

    @Test(expected = CalculationError.class)
    public void testFunctionWithMaxArguments() throws Exception {
        calculator.calculate("sin (2, 3, 7)");
    }
}
