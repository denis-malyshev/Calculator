package com.teamdev.calculator.parser;


import com.teamdev.calculator.*;

public class RightBracketParser implements ExpressionParser {

    @Override
    public EvaluationCommand accept(MathExpressionReader reader) {

        if (!reader.hasMoreElements()) {
            return null;
        }

        final String expression = reader.getRemainingExpression();

        if (expression.startsWith(")")) {

            reader.movePosition(1);

            return new EvaluationCommand() {
                @Override
                public void execute(EvaluationStack outputContext) throws CalculationError {

                    if (outputContext.getOperandStack().size() == 1) {
                        throw new CalculationError("Unexpected left bracket.", reader.getPosition());
                    }

                    outputContext.popAllOperators();
                    double result = outputContext.getOperandStack().pop().pop();
                    outputContext.getOperandStack().peek().push(result);
                    outputContext.getOperatorStack().pop();
                }
            };
        }
        return null;
    }
}