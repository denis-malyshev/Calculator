package com.teamdev.calculator;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class VariableTest {

    final MathExpressionCalculator calculator = new MathExpressionCalculator();
    final Map<String, Double> variables = calculator.getVariables();

    @Test
    public void writeVariableWithShortName() throws Exception {
        calculator.calculate("a = 2;");
        assertNotNull("The variable value must exist.", variables.get("a"));
    }

    @Test
    public void writeVariableWithLongName() throws Exception {
        calculator.calculate("variable = 2;");
        assertNotNull("The variable must exist.", variables.get("variable"));
    }

    @Test
    public void writeHardExpressionInVariable() throws Exception {
        calculator.calculate("variable = 2 * sum ( sqrt (sum (3, 6) * sin (90)), 5, 0, 2));");
        assertNotNull("The variable must exist.", variables.get("variable"));
    }

    @Test
    public void readVariableWithShortName() throws Exception {
        calculator.calculate("a = 2;");
        assertEquals("The variable value must be 2.0.", 2.0, variables.get("a"), 0);
    }

    @Test
    public void readHardExpressionInVariable() throws Exception {
        //sqrt (sum (3, 6) * sin (90) = 3
        //sum ( sqrt (sum (3, 6) * sin (90)), 5, 0, 2) = 10
        calculator.calculate("variable = 2 * sum ( sqrt (sum (3, 6) * sin (90)), 5, 0, 2));");
        assertEquals("The variable value must be 20.0.", 20.0, variables.get("variable"), 0);
    }
}
