package com.teamdev.calculator.parser;

import com.teamdev.calculator.*;

import java.util.ArrayDeque;

public class LeftBracketParser implements ExpressionParser {

    @Override
    public EvaluationCommand accept(MathExpressionReader reader) {

        if (!reader.hasMoreElements()) {
            return null;
        }

        final String expression = reader.getRemainingExpression();

        if (expression.startsWith("(")) {

            reader.movePosition(1);

            return new EvaluationCommand() {
                @Override
                public void execute(EvaluationStack outputContext) {

                    outputContext.getOperatorStack().push(new ArrayDeque<>());
                    outputContext.getOperandStack().push(new ArrayDeque<>());
                }
            };
        }
        return null;
    }
}
