package com.teamdev.calculator;

import com.teamdev.fsm.AbstractFiniteStateMachine;
import com.teamdev.calculator.parser.ExpressionParserFactory;

public class MathExpressionCalculator extends AbstractFiniteStateMachine<

        MathExpressionReader,
        EvaluationStack,
        CalculationState,
        EvaluationCommand,
        ExpressionParser,
        CalculationMatrix,
        CalculationError,
        Double>

        implements Calculator {

    final private ExpressionParserFactory parserFactory = new ExpressionParserFactory();
    final private CalculationMatrix matrix = new CalculationMatrix();

    @Override
    public double calculate(String expression) throws CalculationError {
        return run(new MathExpressionReader(expression), new EvaluationStack());
    }


    @Override
    protected Double prepareResult(EvaluationStack context) {
        return context.getOperandStack().peek().pop();
    }

    @Override
    protected void deadlock(MathExpressionReader context) throws CalculationError {
        throw new CalculationError("Invalid input value on " + context.getPosition()
                + " position", context.getPosition());
    }

    @Override
    protected ExpressionParser getStateAcceptor(CalculationState state) {
        return parserFactory.getParser(state);
    }

    @Override
    protected CalculationMatrix getTransitionMatrix() {
        return matrix;
    }

}
