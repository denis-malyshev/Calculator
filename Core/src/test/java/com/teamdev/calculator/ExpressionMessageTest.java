package com.teamdev.calculator;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ExpressionMessageTest {

    final MathExpressionCalculator calculator = new MathExpressionCalculator();

    @Test
    public void testInvalidValuePosition(){
        try {
            calculator.calculate("565*2-345+567-a");
        } catch (CalculationError calculationError) {
            assertEquals("Invalid input value on 14 position",calculationError.getMessage());
        }
    }

    @Test
    public void testEmptyExpression() throws Exception {
        try {
            calculator.calculate("");
        } catch (CalculationError calculationError) {
            assertEquals("Invalid input value on 0 position",calculationError.getMessage());
        }
    }
}
