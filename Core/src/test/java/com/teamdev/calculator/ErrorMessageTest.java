package com.teamdev.calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class ErrorMessageTest {

    final MathExpressionCalculator calculator = new MathExpressionCalculator();
    AtomicReference<CalculationError> exception;

    @Before
    public void setUp() throws Exception {
        exception = new AtomicReference();
    }

    @After
    public void tearDown() throws Exception {
        exception = null;
    }

    @Test
    public void testInvalidValuePosition() {
        try {
            calculator.calculate(" 565 * 2 - 345 + 567 - a ");
        } catch (CalculationError calculationError) {
            exception.set(calculationError);
        }
        assertNotNull(exception.get());
        assertEquals("Invalid input value on 23 position", exception.get().getMessage());
    }

    @Test
    public void testEmptyExpression() {
        try {
            calculator.calculate("");
        } catch (CalculationError calculationError) {
            exception.set(calculationError);
        }
        assertNotNull(exception.get());
        assertEquals("Invalid input value on 0 position", exception.get().getMessage());
    }

    @Test
    public void testExpressionWithShortageRightBracket() {
        try {
            calculator.calculate(" 2-3+5)");
        } catch (CalculationError calculationError) {
            exception.set(calculationError);
        }
        assertNotNull(exception.get());
        assertEquals("Unexpected left bracket.", exception.get().getMessage());
    }

    @Test
    public void testExpressionWithShortageLeftBracket() {
        try {
            calculator.calculate(" 2-3+5)");
        } catch (CalculationError calculationError) {
            exception.set(calculationError);
        }
        assertNotNull(exception.get());
        assertEquals("Unexpected left bracket.", exception.get().getMessage());
    }
}
