package com.teamdev.calculator;

import com.teamdev.fsm.OutputContext;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluationStack implements OutputContext {

    private Deque<Deque<Double>> operandStack = new ArrayDeque<>();
    private Deque<Deque<BinaryOperator>> operatorStack = new ArrayDeque<>();

    public EvaluationStack() {
        operandStack.push(new ArrayDeque<>());
        operatorStack.push(new ArrayDeque<>());
    }

    public Deque<Deque<Double>> getOperandStack() {
        return operandStack;
    }

    public Deque<Deque<BinaryOperator>> getOperatorStack() {
        return operatorStack;
    }

    public void popAllOperators() throws CalculationError {
        while (!operatorStack.peek().isEmpty()) {

            popOperator();
        }
    }

    private void popOperator() throws CalculationError {
        final Double rightOperand = operandStack.peek().pop();
        final Double leftOperand = operandStack.peek().pop();

        final BinaryOperator binaryOperator = operatorStack.peek().pop();

        final double result = binaryOperator.execute(leftOperand, rightOperand);

        operandStack.peek().push(result);
    }

    public void pushBinaryOperator(BinaryOperator operator) throws CalculationError {

        while (!operatorStack.peek().isEmpty() &&
                (operatorStack.peek().peek().compareTo(operator) > -1)) {

            popOperator();

        }

        operatorStack.peek().push(operator);
    }
}
