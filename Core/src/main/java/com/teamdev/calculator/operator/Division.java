package com.teamdev.calculator.operator;


import com.teamdev.calculator.CalculationError;

public class Division extends AbstractBinaryOperator {

    public Division(Priority priority) {
        super(priority);
    }

    @Override
    public double execute(double leftOperand, double rightOperand) throws CalculationError {
        if (rightOperand == 0)
            throw new CalculationError("Division by zero");
        return leftOperand / rightOperand;
    }
}
