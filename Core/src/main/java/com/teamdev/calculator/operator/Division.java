package com.teamdev.calculator.operator;


public class Division extends AbstractBinaryOperator {

    public Division(Priority priority) {
        super(priority);
    }

    @Override
    public double execute(double leftOperand, double rightOperand) {
        return leftOperand / rightOperand;
    }
}
