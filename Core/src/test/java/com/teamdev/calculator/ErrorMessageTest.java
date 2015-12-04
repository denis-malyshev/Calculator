package com.teamdev.calculator;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.fail;

public class ErrorMessageTest {

    final MathExpressionCalculator calculator = new MathExpressionCalculator();

    @Test
    public void divisionByZero() {
        try {
            calculator.calculate(" out (2 / 0);");
            fail();
        } catch (CalculationError calculationError) {
            assertEquals("Division by zero.", calculationError.getMessage());
        }
    }

    @Test
    public void rootOfNegativeNumber() throws Exception {
        try {
            calculator.calculate(" out (sqrt( -1 ));");
            fail();
        } catch (CalculationError calculationError) {
            assertEquals("Negative value.", calculationError.getMessage());
        }
    }

}
