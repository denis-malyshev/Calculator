package com.teamdev.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionCalculatorTest {

    final MathExpressionCalculator calculator = new MathExpressionCalculator();

    @Test
    public void calculateSimpleExpression() throws Exception {
        double result = calculator.calculate(" 2 + 3 + 7 - 9 - 5 + 4 - 10 + 16 ");
        assertEquals("This expression must be calculated true.", 8.0, result, 0);
    }

    @Test
    public void calculateExpressionWithManyBrackets() throws Exception {
        double result = calculator.calculate(" 2 * ((3 + ( 8 - 1 + ( 2 * (5 - 6)) + 7 - (3 - 2))))");
        assertEquals("This expression must be calculated true.", 28.0, result, 0);
    }

    @Test
    public void calculateExpressionWithFunctionSum() throws Exception {
        double result = calculator.calculate(" 2 * (sum (2, 3, 4 )) ");
        assertEquals("This expression must be calculated true.", 18.0, result, 0);
    }

    @Test
    public void calculateExpressionWithFunctionSqrt() throws Exception {
        double result = calculator.calculate(" 2 * (3 + sqrt (3) ");
        assertEquals("This expression must be calculated true.", 1.73, result, 0.01);
    }

    @Test
    public void calculateExpressionWithFunctionMax() throws Exception {
        double result = calculator.calculate(" 2 * (3 + min ( -6, 3, 8, 19, 17, 100, 5) ");
        assertEquals("This expression must be calculated true.", 200.0, result, 0);
    }

    @Test
    public void calculateExpressionWithFunctionMin() throws Exception {
        double result = calculator.calculate(" 2 * (  + min ( -6, 3, 8, min (3, 8, 2, 0), 17, 100, 5) ");
        assertEquals("This expression must be calculated true.", -6.0, result, 0);
    }
}
