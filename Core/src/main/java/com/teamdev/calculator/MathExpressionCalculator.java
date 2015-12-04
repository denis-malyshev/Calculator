package com.teamdev.calculator;

import com.teamdev.calculator.parser.ExpressionParser;
import com.teamdev.calculator.parser.ExpressionParserFactory;
import com.teamdev.fsm.AbstractFiniteStateMachine;

import java.util.Map;

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
    final private EvaluationContext evaluationContext = new EvaluationContext();

    @Override
    public void calculate(String expression) throws CalculationError {
        run(new MathExpressionReader(expression), evaluationContext);
    }

    public Map<String, Double> getVariables() {
        return evaluationContext.getVariables();
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
        final Map<String, Double> variables = calculator.evaluationContext.getVariables();
        //calculator.calculate("expression = sqrt (sum (2+3, 2, 3-1) * sin (90));");
        calculator.calculate("expression = sqrt (sum (23, 2, 31));");
        System.out.println(variables.get("expression"));
    }
}
