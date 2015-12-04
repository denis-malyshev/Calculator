package com.teamdev.calculator.parser;

import com.teamdev.calculator.*;

public class EndOfExpressionParser implements ExpressionParser {

    @Override
    public EvaluationCommand accept(MathExpressionReader reader) {

        if (reader.hasMoreElements()) {
            return null;
        }

        return new EvaluationCommand() {
            @Override
            public void execute(EvaluationContext outputContext) throws CalculationError {
                outputContext.getEvaluationStack().popAllOperators();
            }
        };
    }
}
