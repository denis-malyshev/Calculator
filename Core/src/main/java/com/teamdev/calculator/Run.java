package com.teamdev.calculator;

import com.teamdev.calculator.gui.CalculatorFrame;

import javax.swing.*;

public class Run {

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculatorFrame();
            }
        });
    }
}
