package com.teamdev.calculator.parser;

import com.teamdev.calculator.*;
import com.teamdev.calculator.operator.BinaryOperatorFactory;
import com.teamdev.calculator.ExpressionParser;

public class BinaryOperatorParser implements ExpressionParser {

    private final BinaryOperatorFactory factory = new BinaryOperatorFactory();

    @Override
    public EvaluationCommand accept(MathExpressionReader reader) {

        if (!reader.hasMoreElements()) {
            return null;
        }

        final String expression = reader.getRemainingExpression();

        for (String presentation : factory.getAllPresentations()) {
            if (expression.startsWith(presentation)) {

                final BinaryOperator operator = factory.getBinaryOperator(presentation);

                reader.movePosition(presentation.length());

                return new EvaluationCommand() {
                    @Override
                    public void execute(EvaluationContext outputContext) throws CalculationError {
                        outputContext.getEvaluationStack().pushBinaryOperator(operator);
                    }
                };
            }
        }
        return null;
    }
}
