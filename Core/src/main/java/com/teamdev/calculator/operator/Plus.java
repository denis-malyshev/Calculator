package com.teamdev.fsm.test.operator;

import static com.teamdev.fsm.test.operator.AbstractBinaryOperator.Priority.LOW;

public class Plus extends AbstractBinaryOperator {

    public Plus(Priority priority) {
        super(priority);
    }

    @Override
    public double execute(double leftOperand, double rightOperand) {
        return leftOperand + rightOperand;
    }
}
