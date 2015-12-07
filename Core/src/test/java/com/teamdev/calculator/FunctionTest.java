package com.teamdev.calculator;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FunctionTest {

    final MathExpressionCalculator calculator = new MathExpressionCalculator();
    final Map<String, Double> variables = calculator.getVariables();

    @Test
    public void calculateSum() throws Exception {
        calculator.calculate(" a = (sum (2,4,6,8));");
        assertEquals("This expression must be calculated true.", 20.0, variables.get("a"), 0);
    }

    @Test
    public void calculateSumWithNestedFunctionSum() throws Exception {
        calculator.calculate(" a = (sum (2,4,sum (3, 7, 8, -1),8));");
        assertEquals("This expression must be calculated true.", 31.0, variables.get("a"), 0);
    }

    @Test
    public void calculateExpressionWithNestedFunctions() throws Exception {
        //sum (2+3, 2, 3-1) * sin (90) = 9
        //sqrt (sum (2+3, 2, 3-1) * sin (90)) = 3
        //sum ( sqrt (sum (2+3, 2, 3-1) * sin (90)), 5, 0, 2) = 10
        calculator.calculate(" expression = 2 * sum ( sqrt (sum (2+3, 2, 3-1) * sin (90)), 5, 0, 2));");
        assertEquals("This expression must be calculated true.", 20.0, variables.get("expression"), 0);
    }
}
