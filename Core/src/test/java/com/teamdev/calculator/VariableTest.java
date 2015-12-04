package com.teamdev.calculator;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class VariableTest {

    final MathExpressionCalculator calculator = new MathExpressionCalculator();
    final Map<String, Double> variables=calculator.getVariables();

    @Test
    public void ReadShortVariable() throws Exception {
        calculator.calculate("a = 2;");
        assertEquals(2.0, variables.get("a"),0);
    }

    @Test
    public void ReadLongVariable() throws Exception {
        calculator.calculate("variable = 2;");
        assertEquals(2.0, variables.get("variable"),0);
    }
}
