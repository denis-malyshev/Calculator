package com.teamdev.calculator;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FunctionTest {

    final MathExpressionCalculator calculator = new MathExpressionCalculator();
    final Map<String, Double> variables=calculator.getVariables();
    static String result = "";
    static final OutputStream outputStream = new OutputStream() {
        @Override
        public void write(int b) throws IOException {
            result += (char) b;
        }
    };

    @BeforeClass
    public static void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() throws Exception {
        result = "";
    }


    @Test
    public void calculateSum() throws Exception {
        calculator.calculate("out(sum (2,4,6,8));");
        assertEquals(20.0, Double.parseDouble(result),0);
    }

    @Test
    public void calculateSum2() throws Exception {
        calculator.calculate("out(sum (2,4,sum (3, 7, 8, -1),8));");
        assertEquals(20.0, Double.parseDouble(result),0);
    }
}
