package com.teamdev.fsm.test;

public interface BinaryOperator extends Comparable<BinaryOperator> {
    double execute(double leftOperand, double rightOperand);
}
