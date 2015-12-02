package com.teamdev.calculator.operator;


public class Minus extends AbstractBinaryOperator {

    public Minus(Priority priority) {
        super(priority);
    }

    @Override
    public double execute(double leftOperand, double rightOperand) {
        return leftOperand - rightOperand;
    }
}
