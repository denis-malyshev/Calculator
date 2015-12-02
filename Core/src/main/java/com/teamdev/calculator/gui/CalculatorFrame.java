package com.teamdev.calculator.gui;

import com.teamdev.calculator.CalculationError;
import com.teamdev.calculator.MathExpressionCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CalculatorFrame extends JFrame {
    private JTextArea expressionArea;
    private JButton calculateButton;
    private final MathExpressionCalculator calculator = new MathExpressionCalculator();

    public CalculatorFrame() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(250, 150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation((dimension.width - getWidth()) / 2, (dimension.height - getHeight()) / 2);
        setTitle("Calculator");
        initializeComponents();
        setLayout(new BorderLayout());
        add(new JScrollPane(expressionArea), BorderLayout.CENTER);
        add(calculateButton, BorderLayout.SOUTH);
    }

    private void initializeComponents() {
        expressionArea = new JTextArea();
        expressionArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        expressionArea.setBorder(BorderFactory.createEmptyBorder());
        calculateButton = new JButton("calculate");
        calculateButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    expressionArea.setText(String.valueOf(calculator.calculate(expressionArea.getText())));
                } catch (CalculationError calculationError) {
                    JOptionPane.showMessageDialog(getParent(),calculationError.getMessage());
                    expressionArea.setCaretPosition(calculationError.getErrorPosition());
                    expressionArea.getCaret().setVisible(true);
                }
            }
        });
    }
}
