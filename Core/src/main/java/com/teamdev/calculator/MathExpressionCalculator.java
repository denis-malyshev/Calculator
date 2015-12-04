package com.teamdev.fsm.test;

import com.teamdev.fsm.AbstractFiniteStateMachine;
import com.teamdev.fsm.test.parser.ExpressionParserFactory;

public class MathExpressionCalculator extends AbstractFiniteStateMachine<

        MathExpressionReader,
        EvaluationContext,
        CalculationState,
        EvaluationCommand,
        ExpressionParser,
        CalculationMatrix,
        CalculationError>

        implements Calculator {

    final private ExpressionParserFactory parserFactory = new ExpressionParserFactory();
    final private CalculationMatrix matrix = new CalculationMatrix();

    @Override
    public void calculate(String expression) throws CalculationError {
        run(new MathExpressionReader(expression), new EvaluationContext());
    }


    @Override
    protected void deadlock(MathExpressionReader context) throws CalculationError {
        throw new CalculationError("", -1);
    }

    @Override
    protected ExpressionParser getStateAcceptor(CalculationState state) {
        return parserFactory.getParser(state);
    }

    @Override
    protected CalculationMatrix getTransitionMatrix() {
        return matrix;
    }

    public static void main(String[] args) throws Exception {
        final MathExpressionCalculator calculator = new MathExpressionCalculator();
        calculator.calculate("a = (2+1); b = a + 5; out( sum (a,b) );");
    }
}
