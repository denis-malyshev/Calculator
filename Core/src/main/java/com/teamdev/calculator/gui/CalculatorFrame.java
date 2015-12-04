package com.teamdev.calculator.gui;

import com.teamdev.calculator.CalculationError;
import com.teamdev.calculator.MathExpressionCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class CalculatorFrame extends JFrame {
    private JTextArea expressionArea;
    private JButton calculateButton;
    private JTextField result;
    private final MathExpressionCalculator calculator = new MathExpressionCalculator();
    private final static Font FONT = new Font("Consolas", Font.PLAIN, 13);

    public CalculatorFrame() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(250, 150);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation((dimension.width - getWidth()) / 2, (dimension.height - getHeight()) / 2);
        setTitle("Calculator");
        initializeComponents();
        final JPanel resultContainer = new JPanel(new BorderLayout());
        resultContainer.add(new JLabel(" Result = "), BorderLayout.WEST);
        resultContainer.add(result, BorderLayout.CENTER);
        setLayout(new GridBagLayout());
        add(new JScrollPane(expressionArea), new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        add(resultContainer, new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(calculateButton, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    }

    private void initializeComponents() {
        expressionArea = new JTextArea();
        expressionArea.setFont(FONT);
        result = new JTextField();
        result.setFont(FONT);
        initInput(result);
        calculateButton = new JButton("calculate");
        calculateButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    calculator.calculate(expressionArea.getText());
                } catch (CalculationError calculationError) {
                    JOptionPane.showMessageDialog(getParent(), calculationError.getMessage());
                    expressionArea.setCaretPosition(calculationError.getErrorPosition());
                    expressionArea.getCaret().setVisible(true);
                }
            }
        });
    }

    private void initInput(JTextField result) {
        final OutputStream outputStream = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                result.setText(result.getText() + (char) b);
            }
        };
        System.setOut(new PrintStream(outputStream));
    }
}
