package com.teamdev.fsm.test.operator;

import com.teamdev.fsm.test.BinaryOperator;

import static com.teamdev.fsm.test.operator.AbstractBinaryOperator.Priority.MEDIUM;

public class Multiply extends AbstractBinaryOperator {

    public Multiply(Priority priority) {
        super(priority);
    }

    @Override
    public double execute(double leftOperand, double rightOperand) {
        return leftOperand * rightOperand;
    }
}
