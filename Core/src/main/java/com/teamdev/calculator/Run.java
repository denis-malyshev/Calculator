package com.teamdev.calculator;

import com.teamdev.calculator.gui.CalculatorFrame;

import javax.swing.*;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) throws Exception {
        if (args[0].equals("gui")) {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new CalculatorFrame();
                }
            });
        }
        if (args[0].equals("console")) {
            final MathExpressionCalculator calculator = new MathExpressionCalculator();
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String expression = scanner.next();
                final double result = calculator.calculate(expression);
                System.out.println("result = " + result);
            }
        }
    }
}
