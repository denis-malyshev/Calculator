package com.teamdev.calculator;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.fail;

public class CalculationErrorTest {

    final MathExpressionCalculator calculator = new MathExpressionCalculator();

    @Test
    public void errorMessageForDivisionByZero() {
        try {
            calculator.calculate(" out (2 / 0);");
            fail();
        } catch (CalculationError calculationError) {
            assertEquals("Division by zero.", calculationError.getMessage());
        }
    }

    @Test
    public void errorMessageByRootFromNegativeNumber() throws Exception {
        try {
            calculator.calculate(" out (sqrt( -1 ));");
            fail();
        } catch (CalculationError calculationError) {
            assertEquals("Negative value.", calculationError.getMessage());
        }
    }
}
